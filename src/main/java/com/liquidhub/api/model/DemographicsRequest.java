package com.liquidhub.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Patient Demographics Request message
 */
@ApiModel(description = "Patient Demographics Request message")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-06T08:45:35.392Z")

public class DemographicsRequest   {
  @JsonProperty("batchControl")
  private BatchControl batchControl = null;

  @JsonProperty("demographicsList")
  private List<DemographicsListItem> demographicsList = new ArrayList<DemographicsListItem>();

  public DemographicsRequest batchControl(BatchControl batchControl) {
    this.batchControl = batchControl;
    return this;
  }

   /**
   * Get batchControl
   * @return batchControl
  **/
  @ApiModelProperty(value = "")
  public BatchControl getBatchControl() {
    return batchControl;
  }

  public void setBatchControl(BatchControl batchControl) {
    this.batchControl = batchControl;
  }

  public DemographicsRequest demographicsList(List<DemographicsListItem> demographicsList) {
    this.demographicsList = demographicsList;
    return this;
  }

  public DemographicsRequest addDemographicsListItem(DemographicsListItem demographicsListItem) {
    this.demographicsList.add(demographicsListItem);
    return this;
  }

   /**
   * Get demographicsList
   * @return demographicsList
  **/
  @ApiModelProperty(value = "")
  public List<DemographicsListItem> getDemographicsList() {
    return demographicsList;
  }

  public void setDemographicsList(List<DemographicsListItem> demographicsList) {
    this.demographicsList = demographicsList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DemographicsRequest demographicsRequest = (DemographicsRequest) o;
    return Objects.equals(this.batchControl, demographicsRequest.batchControl) &&
        Objects.equals(this.demographicsList, demographicsRequest.demographicsList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(batchControl, demographicsList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DemographicsRequest {\n");
    
    sb.append("    batchControl: ").append(toIndentedString(batchControl)).append("\n");
    sb.append("    demographicsList: ").append(toIndentedString(demographicsList)).append("\n");
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

