package com.liquidhub.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Patient Identification
 */
@ApiModel(description = "Patient Identification")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-26T15:27:45.582+05:30")
public class Identification   {
  @JsonProperty("sourceId")
  private String sourceId = null;

  @JsonProperty("dataSource")
  private String dataSource = null;

  @JsonProperty("alternateId")
  private String alternateId = null;

  @JsonProperty("alternateSource")
  private String alternateSource = null;

  @JsonProperty("liquidHubId")
  private String liquidHubId = null;
  
  @JsonProperty("registrationDate")
  private String registrationDate = null;
  

  public Identification sourceId(String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

   /**
   * System generated identifier that is unique within the data provider.
   * @return sourceId
  **/
  @ApiModelProperty(example = "null", value = "System generated identifier that is unique within the data provider.")
  public String getSourceId() {
    return sourceId;
  }

  public void setSourceId(String sourceId) {
    this.sourceId = sourceId;
  }

  public Identification dataSource(String dataSource) {
    this.dataSource = dataSource;
    return this;
  }

   /**
   * Name of Data Provider.  E,g, COVANCE
   * @return dataSource
  **/
  @ApiModelProperty(example = "null", value = "Name of Data Provider.  E,g, COVANCE")
  public String getDataSource() {
    return dataSource;
  }

  public void setDataSource(String dataSource) {
    this.dataSource = dataSource;
  }

  public Identification alternateId(String alternateId) {
    this.alternateId = alternateId;
    return this;
  }

   /**
   * Secondary data provider Id.  E.g. Virmedica Patient Id
   * @return alternateId
  **/
  @ApiModelProperty(example = "null", value = "Secondary data provider Id.  E.g. Virmedica Patient Id")
  public String getAlternateId() {
    return alternateId;
  }

  public void setAlternateId(String alternateId) {
    this.alternateId = alternateId;
  }

  public Identification alternateSource(String alternateSource) {
    this.alternateSource = alternateSource;
    return this;
  }

   /**
   * Name of Data Provider.  E,g, VirMedica
   * @return alternateSource
  **/
  @ApiModelProperty(example = "null", value = "Name of Data Provider.  E,g, VirMedica")
  public String getAlternateSource() {
    return alternateSource;
  }

  public void setAlternateSource(String alternateSource) {
    this.alternateSource = alternateSource;
  }

  public Identification liquidHubId(String liquidHubId) {
    this.liquidHubId = liquidHubId;
    return this;
  }

   /**
   * LiquidHub Patient Id
   * @return liquidHubId
  **/
  @ApiModelProperty(example = "null", value = "LiquidHub Patient Id")
  public String getLiquidHubId() {
    return liquidHubId;
  }

  public void setLiquidHubId(String liquidHubId) {
    this.liquidHubId = liquidHubId;
  }
  
  
  /**
   * Registration Date
   * @return registrationDate
  **/
  @ApiModelProperty(example = "null", value = "Registration Date")
  public String getRegistrationDate() {
	return registrationDate;
  }

  public void setRegistrationDate(String registrationDate) {
	this.registrationDate = registrationDate;
  }

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identification identification = (Identification) o;
    return Objects.equals(this.sourceId, identification.sourceId) &&
        Objects.equals(this.dataSource, identification.dataSource) &&
        Objects.equals(this.alternateId, identification.alternateId) &&
        Objects.equals(this.alternateSource, identification.alternateSource) &&
        Objects.equals(this.liquidHubId, identification.liquidHubId) &&
        Objects.equals(this.registrationDate, identification.registrationDate) ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceId, dataSource, alternateId, alternateSource, liquidHubId, registrationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identification {\n");
    
    sb.append("    sourceId: ").append(toIndentedString(sourceId)).append("\n");
    sb.append("    dataSource: ").append(toIndentedString(dataSource)).append("\n");
    sb.append("    alternateId: ").append(toIndentedString(alternateId)).append("\n");
    sb.append("    alternateSource: ").append(toIndentedString(alternateSource)).append("\n");
    sb.append("    liquidHubId: ").append(toIndentedString(liquidHubId)).append("\n");
    sb.append("    registrationDate: ").append(toIndentedString(registrationDate)).append("\n");
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

