package com.liquidhub.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Case Management
 */
@ApiModel(description = "Case Management")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-06T08:45:35.392Z")

public class CaseManagement {
	@JsonProperty("CMSRNumber")
	private String cmSrNumber = null;

	@JsonProperty("primaryProviderId")
	private String primaryProviderId = null;

	@JsonProperty("primaryFacilityId")
	private String primaryFacilityId = null;

	public CaseManagement homePhone(String cmSrNumber) {
		this.cmSrNumber = cmSrNumber;
		return this;
	}

	public CaseManagement workPhone(String primaryProviderId) {
		this.primaryProviderId = primaryProviderId;
		return this;
	}

	public CaseManagement alternatePhone(String primaryFacilityId) {
		this.primaryFacilityId = primaryFacilityId;
		return this;
	}

	/**
	   * Case Management Serial Number
	   * @return cmSrNumber
	  **/
	  @ApiModelProperty(value = "case managemt serial number")
	public String getCmSrNumber() {
		return cmSrNumber;
	}

	public void setCmSrNumber(String cmSrNumber) {
		this.cmSrNumber = cmSrNumber;
	}

	/**
	   * Primary Provider Id
	   * @return primaryProviderId
	  **/
	  @ApiModelProperty(value = "patient's primary provider MDM ID")
	public String getPrimaryProviderId() {
		return primaryProviderId;
	}

	public void setPrimaryProviderId(String primaryProviderId) {
		this.primaryProviderId = primaryProviderId;
	}

	public String getPrimaryFacilityId() {
		return primaryFacilityId;
	}

	/**
	   * Primary Facility Id
	   * @return primaryFacilityId
	  **/
	  @ApiModelProperty(value = "patient's primary facility Portal ID")
	public void setPrimaryFacilityId(String primaryFacilityId) {
		this.primaryFacilityId = primaryFacilityId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CaseManagement caseManagement = (CaseManagement) o;
		return Objects.equals(this.cmSrNumber, caseManagement.cmSrNumber) 
				&& Objects.equals(this.primaryProviderId, caseManagement.primaryProviderId)
				&& Objects.equals(this.primaryFacilityId, caseManagement.primaryFacilityId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cmSrNumber, primaryProviderId, primaryFacilityId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CaseManagement {\n");

		sb.append("    cmSrNumber: ").append(toIndentedString(cmSrNumber)).append("\n");
		sb.append("    primaryProviderId: ").append(toIndentedString(primaryProviderId)).append("\n");
		sb.append("    primaryFacilityId: ").append(toIndentedString(primaryFacilityId)).append("\n");
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
