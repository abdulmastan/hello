/**
 * 
 */
package com.liquidhub.api.repository;

import com.liquidhub.api.model.DemographicsRequest;

/**
 * @author gramaswami
 *
 */
public interface DemographicsRepository {

	/*
	 * Method to add Patient Demographics Details into
	 * LH_PRE_LAND.PRE_LND_PAT_DEMO In a Chunk of chunk size configured Else
	 * Batch Id auto generated and status marked as Closed
	 * 
	 * @param DemographicsRequest
	 * 
	 * @return void
	 * 
	 * @throws Exception
	 */
	public int addPatientDemographics(DemographicsRequest demographicsRequest) throws Exception;
}
