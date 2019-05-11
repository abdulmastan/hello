package com.liquidhub.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Person Full Name
 */
@ApiModel(description = "Person Full Name")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-26T15:27:45.582+05:30")
public class PersonName   {
  @JsonProperty("salutation")
  private String salutation = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("middleName")
  private String middleName = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("suffix")
  private String suffix = null;

  public PersonName salutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

   /**
   * Dr, Mr, Mrs, etc.
   * @return salutation
  **/
  @ApiModelProperty(example = "null", value = "Dr, Mr, Mrs, etc.")
  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  public PersonName lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * Person Last Name
   * @return lastName
  **/
  @ApiModelProperty(example = "null", value = "Person Last Name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public PersonName middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

   /**
   * Person Middle Name
   * @return middleName
  **/
  @ApiModelProperty(example = "null", value = "Person Middle Name")
  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public PersonName firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * Person First Name
   * @return firstName
  **/
  @ApiModelProperty(example = "null", value = "Person First Name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public PersonName suffix(String suffix) {
    this.suffix = suffix;
    return this;
  }

   /**
   * Last Name Suffix e.g. Jr
   * @return suffix
  **/
  @ApiModelProperty(example = "null", value = "Last Name Suffix e.g. Jr")
  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonName personName = (PersonName) o;
    return Objects.equals(this.salutation, personName.salutation) &&
        Objects.equals(this.lastName, personName.lastName) &&
        Objects.equals(this.middleName, personName.middleName) &&
        Objects.equals(this.firstName, personName.firstName) &&
        Objects.equals(this.suffix, personName.suffix);
  }

  @Override
  public int hashCode() {
    return Objects.hash(salutation, lastName, middleName, firstName, suffix);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonName {\n");
    
    sb.append("    salutation: ").append(toIndentedString(salutation)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    suffix: ").append(toIndentedString(suffix)).append("\n");
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

