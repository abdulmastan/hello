/**
 * 
 */
package com.liquidhub.api.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liquidhub.api.model.BatchControl;
import com.liquidhub.api.model.DemographicsListItem;
import com.liquidhub.api.model.DemographicsRequest;
import com.liquidhub.api.service.DemographicsService;
import com.liquidhub.batch.service.BatchService;

/**
 * @author gramaswami
 *
 */
public class DemographicsApiControllerTest { 

	@Mock
	private BatchService batchService;

	@Mock
	DemographicsService demographicsService;
	
	@Mock
	HttpServletRequest request;

	@InjectMocks
	DemographicsApiController demographicsApiController;

	DemographicsRequest demographicsRequest = null;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		createDemographicsRequest();

		// build controller
		mockMvc = MockMvcBuilders.standaloneSetup(demographicsApiController).build();
	}

	/**
	 * Create demographicss request object
	 */
	public void createDemographicsRequest() {

		demographicsRequest = new DemographicsRequest();
		demographicsRequest.setBatchControl(new BatchControl());

		demographicsRequest.setDemographicsList(new ArrayList<DemographicsListItem>());
		demographicsRequest.getDemographicsList().add(new DemographicsListItem());
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testDemographicsAddWithImplicitRequest() throws Exception {

		// mock the service demographicsAdd method result
		when(batchService.findGivenBatchStatus("1")).thenReturn("OPEN");
		when(demographicsService.addDemographics(demographicsRequest)).thenReturn(1);

		// call demographics
		ResultActions resultActions = mockMvc.perform(post("/demographics").contentType(MediaType.APPLICATION_JSON)
				.content(passJsonString(demographicsRequest)));

		// verify the response
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}

	/**
	 * Test explicit demographics batch. 1. Send demographics JSON request with
	 * batch id. 2.Verify the following items in the response I. HTTP success
	 * status II.Content Type -- it must be APPLICATION_JSON_UTF8_VALUE
	 * III.batch Id -- must not be empty
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDemographicsAddWithExplicitRequest() throws Exception {

		// set batch id for explicit demographics batch
		demographicsRequest.getBatchControl().setBatchId("10");

		// mocking the service addDemographics method result
		when(batchService.findGivenBatchStatus("10")).thenReturn("OPEN");
		when(demographicsService.addDemographics(demographicsRequest)).thenReturn(1);

		// call demographics api
		ResultActions resultActions = mockMvc.perform(post("/demographics").contentType(MediaType.APPLICATION_JSON)
				.content(passJsonString(demographicsRequest)));

		// verify the response
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		resultActions.andExpect(jsonPath("$.batchId").isNotEmpty());
		resultActions.andExpect(jsonPath("$.batchId").value("10"));
	}

	/**
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDemographicsAddWithImplicitInternalServerError() throws Exception {

		// mock the service addDemographics result
		when(batchService.findGivenBatchStatus("1")).thenReturn("OPEN");
		when(demographicsService.addDemographics(demographicsRequest)).thenThrow(Exception.class);

		// call demographicss api
		ResultActions resultActions = mockMvc.perform(post("/demographics").contentType(MediaType.APPLICATION_JSON)
				.content(passJsonString(demographicsRequest)));

		resultActions.andExpect(status().isInternalServerError());
		resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}

	/**
	 * Test explicit demographicssAdd with exceptions. 1. Send demographicss
	 * JSON request with empty batch id. 2.Verify the following items in the
	 * response I. HTTP status INTERNAL_SERVER_ERROR II.Content Type -- it must
	 * be application/json III.batch Id
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDemographicsAddWithExplicitInternalServerError() throws Exception {

		// set batch id for explicit patient demographics
		demographicsRequest.getBatchControl().setBatchId("10");

		//mock the response
		when(batchService.findGivenBatchStatus("10")).thenReturn("OPEN");
		when(demographicsService.addDemographics(demographicsRequest)).thenThrow(Exception.class);

		// call demographics api
		ResultActions resultActions = mockMvc.perform(post("/demographics").contentType(MediaType.APPLICATION_JSON)
				.content(passJsonString(demographicsRequest)));

		// verify result
		resultActions.andExpect(status().isInternalServerError());
		resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		resultActions.andExpect(jsonPath("$.batchId").isNotEmpty());
	}

	/**
	 * converting the Object to JSON String using ObjectMapper class
	 * 
	 * @param obj
	 * @return
	 */
	public static String passJsonString(Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
