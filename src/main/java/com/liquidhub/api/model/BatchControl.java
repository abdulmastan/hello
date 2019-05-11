package com.liquidhub.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Batch Control structure
 */
@ApiModel(description = "Batch Control structure")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-06T08:45:35.392Z")

public class BatchControl   {
  @JsonProperty("batchId")
  private String batchId = null;

  @JsonProperty("batchCommand")
  private String batchCommand = null;

  public BatchControl batchId(String batchId) {
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

  public BatchControl batchCommand(String batchCommand) {
    this.batchCommand = batchCommand;
    return this;
  }

   /**
   * Batch control command, to begin, continue, and end a batch within one or more API calls.
   * @return batchCommand
  **/
  @ApiModelProperty(value = "Batch control command, to begin, continue, and end a batch within one or more API calls.")
  public String getBatchCommand() {
    return batchCommand;
  }

  public void setBatchCommand(String batchCommand) {
    this.batchCommand = batchCommand;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchControl batchControl = (BatchControl) o;
    return Objects.equals(this.batchId, batchControl.batchId) &&
        Objects.equals(this.batchCommand, batchControl.batchCommand);
  }

  @Override
  public int hashCode() {
    return Objects.hash(batchId, batchCommand);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchControl {\n");
    
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
    sb.append("    batchCommand: ").append(toIndentedString(batchCommand)).append("\n");
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

