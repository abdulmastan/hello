package com.liquidhub.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.liquidhub.api.model.BatchControl;
import com.liquidhub.api.model.DemographicsRequest;
import com.liquidhub.api.repository.DemographicsRepository;
import com.liquidhub.batch.service.BatchService;

@Service
public class DemographicsServiceImpl implements DemographicsService {

	private static final Logger logger = LoggerFactory.getLogger(DemographicsServiceImpl.class);

	// Below property is the statuses used in batch status table.
	@Value("${batchStatus.open}")
	private String statusOpen;

	@Autowired
	private DemographicsRepository demographicsRepository;

	@Autowired
	private BatchService batchService;

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
	@Override
	@Transactional
	public int addDemographics(DemographicsRequest demographicsRequest) throws Exception {

		logger.info("DemographicsServiceImpl - addDemographics method START::");

		BatchControl batchControl = demographicsRequest.getBatchControl();
		Boolean implicitFlag = false;

		// check batch type -- it is implicit batch or explicit batch
		if (batchControl != null && StringUtils.isEmpty(batchControl.getBatchId())) {

			logger.info("DemographicsServiceImpl - addDemographics method implicit batch flow");

			// Create new batch Id for implicit batch
			Integer batchId = batchService.create();

			// set batch Id to provide request
			demographicsRequest.getBatchControl().setBatchId(batchId.toString());

			implicitFlag = true;
		}

		// Batch status should be OPEN for both cases -- implicit and explicit
		demographicsRequest.getBatchControl().setBatchCommand(statusOpen);

		// save patient demographics data into database
		int result = demographicsRepository.addPatientDemographics(demographicsRequest);

		// In case of implicit batch, close the batch
		if (implicitFlag) {

			batchService.close(demographicsRequest.getBatchControl().getBatchId());
		}

		logger.info("DemographicsServiceImpl - addDemographics method END::");
		
		return result;
	}

}