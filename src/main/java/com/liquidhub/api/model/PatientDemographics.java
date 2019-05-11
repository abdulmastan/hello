package com.liquidhub.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Patient Limited Demographics
 */
@ApiModel(description = "Patient Limited Demographics")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-26T15:27:45.582+05:30")
public class PatientDemographics   {
  @JsonProperty("dateOfBirth")
  private String dateOfBirth = null;

  @JsonProperty("gender")
  private String gender = null;

  @JsonProperty("ssn")
  private String ssn = null;

  public PatientDemographics dateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

   /**
   * Full and true/actual date of birth
   * @return dateOfBirth
  **/
  @ApiModelProperty(example = "null", value = "Full and true/actual date of birth")
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public PatientDemographics gender(String gender) {
    this.gender = gender;
    return this;
  }

   /**
   * Patient Gender
   * @return gender
  **/
  @ApiModelProperty(example = "null", value = "Patient Gender")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public PatientDemographics ssn(String ssn) {
    this.ssn = ssn;
    return this;
  }

   /**
   * Leave Blank.  For future use
   * @return ssn
  **/
  @ApiModelProperty(example = "null", value = "Leave Blank.  For future use")
  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientDemographics patientDemographics = (PatientDemographics) o;
    return Objects.equals(this.dateOfBirth, patientDemographics.dateOfBirth) &&
        Objects.equals(this.gender, patientDemographics.gender) &&
        Objects.equals(this.ssn, patientDemographics.ssn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateOfBirth, gender, ssn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientDemographics {\n");
    
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    ssn: ").append(toIndentedString(ssn)).append("\n");
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

