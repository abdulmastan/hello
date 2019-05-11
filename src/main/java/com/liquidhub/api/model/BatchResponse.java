package com.liquidhub.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Batch Control and general Response Structure
 */
@ApiModel(description = "Batch Control and general Response Structure")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-06T08:45:35.392Z")

public class BatchResponse   {
  @JsonProperty("batchId")
  private String batchId = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("errorMessage")
  private List<String> errorMessage = new ArrayList<String>();

  public BatchResponse batchId(String batchId) {
    this.batchId = batchId;
    return this;
  }

   /**
   * API Assigned batch identifier used to submit record groups.
   * @return batchId
  **/
  @ApiModelProperty(value = "API Assigned batch identifier used to submit record groups.")
  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public BatchResponse status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Success or failure status (HTTP Status Code)
   * @return status
  **/
  @ApiModelProperty(value = "Success or failure status (HTTP Status Code)")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BatchResponse errorMessage(List<String> errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  public BatchResponse addErrorMessageItem(String errorMessageItem) {
    this.errorMessage.add(errorMessageItem);
    return this;
  }

   /**
   * List of error messages on error.
   * @return errorMessage
  **/
  @ApiModelProperty(value = "List of error messages on error.")
  public List<String> getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(List<String> errorMessage) {
    this.errorMessage = errorMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchResponse batchResponse = (BatchResponse) o;
    return Objects.equals(this.batchId, batchResponse.batchId) &&
        Objects.equals(this.status, batchResponse.status) &&
        Objects.equals(this.errorMessage, batchResponse.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(batchId, status, errorMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchResponse {\n");
    
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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

