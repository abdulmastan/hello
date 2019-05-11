package com.liquidhub.api.service;

import com.liquidhub.api.model.DemographicsRequest;

public interface DemographicsService {

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
	public int addDemographics(DemographicsRequest demographicsRequest) throws Exception;

}
