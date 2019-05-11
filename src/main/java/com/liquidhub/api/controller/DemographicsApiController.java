package com.liquidhub.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liquidhub.api.model.BatchControl;
import com.liquidhub.api.model.BatchResponse;
import com.liquidhub.api.model.DemographicsListItem;
import com.liquidhub.api.model.DemographicsRequest;
import com.liquidhub.api.model.Identification;
import com.liquidhub.api.service.DemographicsService;
import com.liquidhub.api.utility.DemographicsUtil;
import com.liquidhub.batch.service.BatchService;

import io.swagger.annotations.ApiParam;
import net.logstash.logback.marker.Markers;

@RestController
public class DemographicsApiController extends AllerganApiController implements DemographicsApi {

	private static final Logger logger = LoggerFactory.getLogger(DemographicsApiController.class);

	@Autowired
	private BatchService batchService;

	@Autowired
	private DemographicsService demographicsService;
	
	@Autowired
	HttpServletRequest request;

	/*
	 * Method to add Patient Demographics Details into
	 * LH_PRE_LAND.PRE_LND_PAT_DEMO Verifies whether BatchId is part of request.
	 * If BatchId sent Status marked as Open Else Batch Id auto generated and
	 * status marked as Closed LH_PRE_LAND.LH_BATCH_DTLS marked as Closed
	 * 
	 * @param DemographicsRequest
	 * 
	 * @return void
	 * 
	 * @throws Exception
	 */
	public ResponseEntity<BatchResponse> demographicsAdd(
			@ApiParam(value = "", required = true) @RequestBody DemographicsRequest message) {

		logger.info("DemographicsApiController - demographicsAdd method START::");

		BatchResponse batchResponse = new BatchResponse();

		try {
			logger.debug("Received Demographics request::"+message.toString()); 
			
			//Source Ip address base to create micro services flows in ELK stack
			String srcIpAddress = request.getHeader(sourceIpAddress);
			Marker ipAddressMarker = Markers.append(sourceIpAddress, srcIpAddress);			
			logger.info(ipAddressMarker, "Source IP address:{}", srcIpAddress);
			
			// BatchControl object made as optional,so create and set new Batch Control
			// to demographics request if Batch Control info is not there in the request.
			if (message.getBatchControl() == null) {

				message.setBatchControl(new BatchControl());
			}

			// Anything goes wrong in providers data, treat it is a bad
			// resource and send back resource error response.
			if (validateDemographicsRequest(message, batchResponse, batchService)) {

				return new ResponseEntity<BatchResponse>(batchResponse, HttpStatus.BAD_REQUEST);
			}

			// Service call to insert patient demographics data.
			demographicsService.addDemographics(message);

			// set batch id and status
			batchResponse.setBatchId(message.getBatchControl().getBatchId());
			batchResponse.setStatus(success);

		} catch (Exception ex) {

			String errorMsg = ex.getCause()==null?ex.getMessage():ex.getCause().getMessage();
			logger.error("Error occured in demographicsAdd flow:: " + DemographicsUtil.getStackTrace(ex));

			// set internal server error
			DemographicsUtil.setInternalServerErrorResponse(message.getBatchControl().getBatchId(), internalServerError,
					errorMsg, batchResponse);
			
			/*DemographicsUtil.setInternalServerErrorResponse(message.getBatchControl().getBatchId(), internalServerError,
					ex.getMessage(), batchResponse);*/

			return new ResponseEntity<BatchResponse>(batchResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("DemographicsApiController - demographicsAdd method END::");

		return new ResponseEntity<BatchResponse>(batchResponse, HttpStatus.OK);
	}

	/*
	 * Out of scope as of now.
	 * 
	 * @see
	 * com.liquidhub.api.controller.DemographicsApi#demographicsFindByDate(java.
	 * lang.String)
	 */
	public ResponseEntity<List<Identification>> demographicsFindByDate(
			@NotNull @ApiParam(value = "", required = true) @RequestParam(value = "statusDate", required = true) String statusDate) {
		return new ResponseEntity<List<Identification>>(HttpStatus.OK);
	}

	/*
	 * Out of scope as of now.
	 * 
	 * @see
	 * com.liquidhub.api.controller.DemographicsApi#demographicsFindById(java.
	 * lang.String, java.lang.String, java.lang.String)
	 */
	public ResponseEntity<List<DemographicsListItem>> demographicsFindById(
			@ApiParam(value = "") @RequestParam(value = "liquidHubPatientId", required = false) String liquidHubPatientId,
			@ApiParam(value = "") @RequestParam(value = "sourcePatientId", required = false) String sourcePatientId,
			@ApiParam(value = "") @RequestParam(value = "alternatePatientId", required = false) String alternatePatientId) {

		return new ResponseEntity<List<DemographicsListItem>>(HttpStatus.OK);
	}

}