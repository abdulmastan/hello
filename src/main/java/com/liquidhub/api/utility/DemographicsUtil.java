package com.liquidhub.api.utility;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.liquidhub.api.model.BatchResponse;

@Component
public class DemographicsUtil {
	private static final Logger logger = LoggerFactory.getLogger(DemographicsUtil.class);
	
	private static String badRequestDesc;

	private static String internalServerErrorDesc; 

	//public static String batchStatus;

	public static String batchIdNotToOpenDesc;

	public static String demographicsListEmpty;
	
	public static String batchIdNotExists;
	
	
		
	@Value("${bad.request.desc}")
	public void setBadRequest(String badRequestDesc) {
		DemographicsUtil.badRequestDesc = badRequestDesc;
	}

	@Value("${internal.server.error.desc}")
	public void setInternalServerError(String internalServerErrorDesc) {
		DemographicsUtil.internalServerErrorDesc = internalServerErrorDesc;
	}

	@Value("${batchId.not.to.open.desc}")
	public void setBatchIdNotToOpen(String batchIdNotToOpenDesc) {
		DemographicsUtil.batchIdNotToOpenDesc = batchIdNotToOpenDesc;
	}

	@Value("${demographics.list.empty}") 
	public void setdemographicsListEmpty(String demographicsListEmpty) {
		DemographicsUtil.demographicsListEmpty = demographicsListEmpty;
	}
	
	@Value("${batchId.not.exists.desc}")
	public void setBatchIdNotExists(String batchIdNotExists){
		DemographicsUtil.batchIdNotExists = batchIdNotExists;
	}

	/**
	 * This method converts Exception stack trace to String
	 * 
	 * @param t
	 * @return
	 */
	public static String getStackTrace(Throwable t) {
		logger.info("Converting statck trace to String");
		StringWriter sw = new StringWriter();
		t.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}
	
	/**
	 * @param batchId
	 * @param status
	 * @param errorMsg
	 * @param batchResponse
	 */
	public static void setBadRequestErrorResponse(String batchId, String status, String errorDesc,
			BatchResponse batchResponse) {

		batchResponse.setBatchId(batchId);
		batchResponse.setStatus(status);

		// set error messages
		batchResponse.getErrorMessage().add(badRequestDesc);
		batchResponse.getErrorMessage().add(errorDesc);
	}

	/**
	 * @param batchId
	 * @param status
	 * @param errorMsg
	 * @param batchResponse
	 */
	public static void setInternalServerErrorResponse(String batchId, String status, String errorMsg,
			BatchResponse batchResponse) {

		batchResponse.setBatchId(batchId);
		batchResponse.setStatus(status);

		// set error messages
		batchResponse.getErrorMessage().add(internalServerErrorDesc);
		batchResponse.getErrorMessage().add(errorMsg);
	}
	
}