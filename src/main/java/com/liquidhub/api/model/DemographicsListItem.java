package com.liquidhub.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Patient Demographics List Item
 */
@ApiModel(description = "Patient Demographics List Item")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-26T15:27:45.582+05:30")
public class DemographicsListItem   {
	
  @JsonProperty("patientRecordStatus")
  private String patientRecordStatus = null;

  @JsonProperty("practiceAssociation")
  private String practiceAssociation = null;

  @JsonProperty("patientIdentification")
  private Identification patientIdentification = null;

  @JsonProperty("patientName")
  private PersonName patientName = null;

  @JsonProperty("patientAddress")
  private Address patientAddress = null;

  @JsonProperty("patientDemographics")
  private PatientDemographics patientDemographics = null;

  @JsonProperty("patientContact")
  private Contact patientContact = null;

  @JsonProperty("caseManagement")
  private CaseManagement caseManagement = null;
  
  public DemographicsListItem patientIdentification(Identification patientIdentification) {
    this.patientIdentification = patientIdentification;
    return this;
  }
  
  
  /**
   * Get patientRecordStatus
   * @return patientRecordStatus
  **/
  @ApiModelProperty(example = "null", value = "Patient Record Status")
	public String getPatientRecordStatus() {
		return patientRecordStatus;
	}

	public void setPatientRecordStatus(String patientRecordStatus) {
		this.patientRecordStatus = patientRecordStatus;
	}

	/**
	   * Get practiceAssociation
	   * @return practiceAssociation
	  **/
	@ApiModelProperty(example = "null", value = "Practice Association Id")
	public String getPracticeAssociation() {
		return practiceAssociation;
	}

	public void setPracticeAssociation(String practiceAssociation) {
		this.practiceAssociation = practiceAssociation;
	}



/**
   * Get patientIdentification
   * @return patientIdentification
  **/
  @ApiModelProperty(example = "null", value = "")
  public Identification getPatientIdentification() {
    return patientIdentification;
  }

  public void setPatientIdentification(Identification patientIdentification) {
    this.patientIdentification = patientIdentification;
  }

  public DemographicsListItem patientName(PersonName patientName) {
    this.patientName = patientName;
    return this;
  }

   /**
   * Get patientName
   * @return patientName
  **/
  @ApiModelProperty(example = "null", value = "")
  public PersonName getPatientName() {
    return patientName;
  }

  public void setPatientName(PersonName patientName) {
    this.patientName = patientName;
  }

  public DemographicsListItem patientAddress(Address patientAddress) {
    this.patientAddress = patientAddress;
    return this;
  }

   /**
   * Get patientAddress
   * @return patientAddress
  **/
  @ApiModelProperty(example = "null", value = "")
  public Address getPatientAddress() {
    return patientAddress;
  }

  public void setPatientAddress(Address patientAddress) {
    this.patientAddress = patientAddress;
  }

  public DemographicsListItem patientDemographics(PatientDemographics patientDemographics) {
    this.patientDemographics = patientDemographics;
    return this;
  }

   /**
   * Get patientDemographics
   * @return patientDemographics
  **/
  @ApiModelProperty(example = "null", value = "")
  public PatientDemographics getPatientDemographics() {
    return patientDemographics;
  }

  public void setPatientDemographics(PatientDemographics patientDemographics) {
    this.patientDemographics = patientDemographics;
  }

  public DemographicsListItem patientContact(Contact patientContact) {
    this.patientContact = patientContact;
    return this;
  }

   /**
   * Get patientContact
   * @return patientContact
  **/
  @ApiModelProperty(example = "null", value = "")
  public Contact getPatientContact() {
    return patientContact;
  }

  public void setPatientContact(Contact patientContact) {
    this.patientContact = patientContact;
  }

  /**
   * Get caseManagement
   * @return caseManagement
  **/
  @ApiModelProperty(example = "null", value = "")
	public CaseManagement getCaseManagement() {
		return caseManagement;
	}

	public void setCaseManagement(CaseManagement caseManagement) {
		this.caseManagement = caseManagement;
	}

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DemographicsListItem demographicsListItem = (DemographicsListItem) o;
    return Objects.equals(this.patientRecordStatus, demographicsListItem.patientRecordStatus) &&
    	Objects.equals(this.practiceAssociation, demographicsListItem.practiceAssociation) &&
    	Objects.equals(this.patientIdentification, demographicsListItem.patientIdentification) &&
        Objects.equals(this.patientName, demographicsListItem.patientName) &&
        Objects.equals(this.patientAddress, demographicsListItem.patientAddress) &&
        Objects.equals(this.patientDemographics, demographicsListItem.patientDemographics) &&
        Objects.equals(this.patientContact, demographicsListItem.patientContact) &&
        Objects.equals(this.caseManagement, demographicsListItem.caseManagement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientRecordStatus, practiceAssociation, patientIdentification, patientName, patientAddress, patientDemographics, patientContact, caseManagement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DemographicsListItem {\n");
    
    sb.append("    patientRecordStatus: ").append(toIndentedString(patientRecordStatus)).append("\n");
    sb.append("    practiceAssociation: ").append(toIndentedString(practiceAssociation)).append("\n");
    sb.append("    patientIdentification: ").append(toIndentedString(patientIdentification)).append("\n");
    sb.append("    patientName: ").append(toIndentedString(patientName)).append("\n");
    sb.append("    patientAddress: ").append(toIndentedString(patientAddress)).append("\n");
    sb.append("    patientDemographics: ").append(toIndentedString(patientDemographics)).append("\n");
    sb.append("    patientContact: ").append(toIndentedString(patientContact)).append("\n");
    sb.append("    caseManagement: ").append(toIndentedString(caseManagement)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

