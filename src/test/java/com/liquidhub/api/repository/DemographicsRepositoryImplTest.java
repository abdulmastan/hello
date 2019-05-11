package com.liquidhub.api.repository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyCollection;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@RunWith(MockitoJUnitRunner.class)
public class DemographicsRepositoryImplTest {

	int batchSize = 100;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	DemographicsRepository demographicsRepository;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
	}

	/**
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAddProvider() throws Exception {
		int result = 1;
		int a[][] = { { 1, 1 }, { 1, 1 } };

		// mock the response
		when(jdbcTemplate.batchUpdate(anyString(), anyCollection(), anyInt(), anyObject())).thenReturn(a);
		when(demographicsRepository.addPatientDemographics(anyObject())).thenReturn(1);

		// verify result
		assertArrayEquals(a, jdbcTemplate.batchUpdate(anyString(), anyCollection(), anyInt(), anyObject()));
		assertEquals(result, demographicsRepository.addPatientDemographics(anyObject()));
	}

	/**
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAddProviderFail() throws Exception {

		int result = 0;

		// mock the response
		when(jdbcTemplate.batchUpdate(anyString(), anyCollection(), anyInt(), anyObject())).thenThrow(Exception.class);

		// verify exception
		assertThatThrownBy(() -> jdbcTemplate.batchUpdate(anyString(), anyCollection(), anyInt(), anyObject()))
				.isInstanceOf(Exception.class);

		// verify result
		assertEquals(result, demographicsRepository.addPatientDemographics(anyObject()));
	}

}