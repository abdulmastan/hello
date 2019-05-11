/**
 * 
 */
package com.liquidhub.api.controller;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.liquidhub.api.model.BatchResponse;
import com.liquidhub.api.model.DemographicsRequest;
import com.liquidhub.api.utility.DemographicsUtil;
import com.liquidhub.batch.service.BatchService;

/**
 * @author gramaswami
 *
 */
public class AllerganApiController { 

	private static final Logger logger = LoggerFactory.getLogger(AllerganApiController.class);

	@Value("${batchResponseStatus.success}")
	protected String success;

	@Value("${batchResponseStatus.resourceError}")
	protected String resourceError;

	@Value("${batchResponseStatus.internalServerError}")
	protected String internalServerError;
	
	protected static String sourceIpAddress = "SOURCE-IP-ADDRESS";

	/**
	 * @param message
	 * @param batchResponse
	 * @param batchService
	 * @return
	 * @throws Exception
	 */
	public boolean validateDemographicsRequest(DemographicsRequest message, BatchResponse batchResponse,
			BatchService batchService) throws Exception {

		String batchId = message.getBatchControl().getBatchId();

		if (message.getDemographicsList() == null || message.getDemographicsList().size() == 0) {

			logger.info("Demographics list is empty.");

			DemographicsUtil.setBadRequestErrorResponse(batchId, resourceError, DemographicsUtil.demographicsListEmpty,
					batchResponse);

			return true;
		}

		// Batch is already in CLOSED/CANCELED state ,it cann't be opened again.
		if (!StringUtils.isEmpty(batchId)) {

			String batchStatus = batchService.findGivenBatchStatus(batchId);

			logger.info("BatchId:" + batchId + " and batch status:" + batchStatus);
			
			//Batch is not a valid batch ,then send resource error response
			if(StringUtils.isEmpty(batchStatus)){
				
				String errorDesc = MessageFormat.format(DemographicsUtil.batchIdNotExists , batchId);
				
				DemographicsUtil.setBadRequestErrorResponse(batchId, resourceError, errorDesc, batchResponse);

				return true;
			}

			// Send resource error if batch is already in CLOSED/CANCELED state
			if ("CLOSED".equals(batchStatus) || "CANCELED".equals(batchStatus)) {

				String errorDesc = MessageFormat.format(DemographicsUtil.batchIdNotToOpenDesc, batchStatus);
				DemographicsUtil.setBadRequestErrorResponse(batchId, resourceError, errorDesc, batchResponse);

				return true;
			}
		}

		return false;
	}

}
