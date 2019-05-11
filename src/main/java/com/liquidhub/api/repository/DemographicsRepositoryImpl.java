/**
 * 
 */
package com.liquidhub.api.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.liquidhub.api.model.Address;
import com.liquidhub.api.model.BatchControl;
import com.liquidhub.api.model.CaseManagement;
import com.liquidhub.api.model.Contact;
import com.liquidhub.api.model.DemographicsListItem;
import com.liquidhub.api.model.DemographicsRequest;
import com.liquidhub.api.model.Identification;
import com.liquidhub.api.model.PatientDemographics;
import com.liquidhub.api.model.PersonName;



/**
 * @author gramaswami
 *
 */
@Repository
public class DemographicsRepositoryImpl implements DemographicsRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(DemographicsRepositoryImpl.class);
	
	@Value("${sql.patDemoInsertQuery}")
	private String patDemoInsertQuery;
	
	@Value("${batchParameters.batchSize}")
	private int batchSize;
		
	@Autowired
	private JdbcTemplate jdbcTemplate;

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
	@Override
	public int addPatientDemographics(DemographicsRequest demographicsRequest) throws Exception {

		logger.info("DemographicsRepositoryImpl - addPatientDemographics method ");

		List<DemographicsListItem> demographicsList = demographicsRequest.getDemographicsList();

		int[][] updateCounts = jdbcTemplate.batchUpdate(patDemoInsertQuery, demographicsList, batchSize,

				new ParameterizedPreparedStatementSetter<DemographicsListItem>() {
					@Override
					public void setValues(PreparedStatement ps, DemographicsListItem demographicsListItem)
							throws SQLException {

						setDemographicsData(ps, demographicsListItem, demographicsRequest.getBatchControl());
					}
				});

		//check updates count size 
		int count = updateCounts != null ? updateCounts.length : 0;

		logger.info(
				"ProvidersRepositoryImpl addProvider method ends:: providers are added successfully and updated counts size:"
						+ count);
		
		logger.info("DemographicsRepositoryImpl - addPatientDemographics method END::");
		
		return count;
	}
	
	
	/**
	 * @param ps
	 * @param provider
	 * @param batchControl
	 * @throws SQLException
	 */
	private void setDemographicsData(PreparedStatement ps, DemographicsListItem demographicsListItem, BatchControl batchControl)
			throws SQLException {

		// set identification data
		Identification identification = demographicsListItem.getPatientIdentification();
		
		if(identification == null){
			identification = new Identification();
		}
		
		ps.setString(1, identification.getSourceId());
		ps.setString(2, identification.getDataSource());
		ps.setString(3, identification.getAlternateId());
		ps.setString(4, identification.getAlternateSource());
		ps.setString(5, identification.getLiquidHubId());
		ps.setString(6, identification.getRegistrationDate());
				
		// set person info
		PersonName personName = demographicsListItem.getPatientName();
		
		if (personName == null) {
			personName = new PersonName();
		}
		
		ps.setString(7, personName.getSalutation());
		ps.setString(8, personName.getLastName());
		ps.setString(9, personName.getMiddleName());
		ps.setString(10, personName.getFirstName());
		ps.setString(11, personName.getSuffix());

		// set address
		Address address = demographicsListItem.getPatientAddress();
		
		if(address == null){
			address = new Address();
		}
		
		ps.setString(12, address.getAddressLine1());
		ps.setString(13, address.getAddressLine2());
		ps.setString(14, address.getCity());
		ps.setString(15, address.getState());
		ps.setString(16, address.getZipCode());
		
		//set patient demographics info
		PatientDemographics demographics = demographicsListItem.getPatientDemographics();
		
		if(demographics == null){
			demographics = new PatientDemographics();
		}
		ps.setString(17,demographics.getDateOfBirth());
		ps.setString(18, demographics.getGender());
		ps.setString(19,demographics.getSsn() != null? demographics.getSsn().toString() :"");

		// set contact info
		Contact contact = demographicsListItem.getPatientContact();
		
		if(contact == null){
			contact = new Contact();
		}
		
		ps.setString(20, contact.getHomePhone());
		ps.setString(21, contact.getWorkPhone());
		ps.setString(22, contact.getAlternatePhone());
		ps.setString(23, contact.getMobilePhone());
		ps.setString(24, contact.getPreferredPhone());
		ps.setString(25, contact.getPreferredContactMethod());
		ps.setString(26, contact.getFax());
		ps.setString(27, contact.getEmail());

		ps.setString(28, demographicsListItem.getPatientRecordStatus());
		ps.setString(29, demographicsListItem.getPracticeAssociation());
		
		CaseManagement caseManagement = demographicsListItem.getCaseManagement();
		
		if(caseManagement == null) {
			caseManagement = new CaseManagement();
		}
		
		//set caseManagement info
		ps.setString(30, caseManagement.getCmSrNumber());
		ps.setString(31, caseManagement.getPrimaryProviderId());
		ps.setString(32, caseManagement.getPrimaryFacilityId());
		// set batch info
		ps.setString(33, batchControl.getBatchId());
		ps.setString(34, batchControl.getBatchCommand());
		ps.setTimestamp(35, new Timestamp(System.currentTimeMillis()));
	}
}