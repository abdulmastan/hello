package com.liquidhub.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.liquidhub.api.model.BatchControl;
import com.liquidhub.api.model.DemographicsListItem;
import com.liquidhub.api.model.DemographicsRequest;
import com.liquidhub.api.repository.DemographicsRepository;
import com.liquidhub.batch.service.BatchServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DemographicsServiceimplTest {
	
	@Mock
	private BatchServiceImpl batchService;
	
	@Mock
	DemographicsRepository demographicsRepository;

	@InjectMocks
	DemographicsServiceImpl demographicsService;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testAttachmentAddExplicitRequest() throws Exception {

		DemographicsRequest demographicsRequest = new  DemographicsRequest();

		// set explicit batch
		demographicsRequest.setBatchControl(new BatchControl());
		demographicsRequest.getBatchControl().setBatchId("10");

		// set demographics list
		demographicsRequest.setDemographicsList(new ArrayList<DemographicsListItem>());

		//mock the response
		when(demographicsRepository.addPatientDemographics(demographicsRequest)).thenReturn(1);

		// call service method
		int result = demographicsService.addDemographics(demographicsRequest);

		// verify result
		assertEquals(1, result);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testAttachmentAddImplicitRequest() throws Exception {

		DemographicsRequest demographicsRequest = new  DemographicsRequest();

		// set explicit batch
		demographicsRequest.setBatchControl(new BatchControl());

		// set demographics list
		demographicsRequest.setDemographicsList(new ArrayList<DemographicsListItem>());

		// mock the response
		when(batchService.findGivenBatchStatus("1")).thenReturn("OPEN");
		when(batchService.create()).thenReturn(1);
		when(batchService.close("1")).thenReturn(1);

		when(demographicsRepository.addPatientDemographics(demographicsRequest)).thenReturn(1);

		// call service method
		int result = demographicsService.addDemographics(demographicsRequest);

		// verify result
		assertEquals(1, result);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testAttachmentAddFail() throws Exception {

		DemographicsRequest demographicsRequest = new  DemographicsRequest();

		// set batch id
		demographicsRequest.setBatchControl(new BatchControl());
		demographicsRequest.getBatchControl().setBatchId("10");

		//mock the response
		when(demographicsRepository.addPatientDemographics(demographicsRequest)).thenReturn(0);

		// call service method
		int result = demographicsService.addDemographics(demographicsRequest);

		assertEquals(0, result);
	}


}