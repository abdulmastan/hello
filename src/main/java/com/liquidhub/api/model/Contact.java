package com.liquidhub.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Contact Info
 */
@ApiModel(description = "Contact Info")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-06T08:45:35.392Z")

public class Contact   {
  @JsonProperty("homePhone")
  private String homePhone = null;

  @JsonProperty("workPhone")
  private String workPhone = null;

  @JsonProperty("alternatePhone")
  private String alternatePhone = null;

  @JsonProperty("mobilePhone")
  private String mobilePhone = null;

  @JsonProperty("preferredPhone")
  private String preferredPhone = null;

  @JsonProperty("preferredContactMethod")
  private String preferredContactMethod = null;

  @JsonProperty("fax")
  private String fax = null;

  @JsonProperty("email")
  private String email = null;

  public Contact homePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

   /**
   * 10 digit phone number, including area code, no formatting
   * @return homePhone
  **/
  @ApiModelProperty(value = "10 digit phone number, including area code, no formatting")
  public String getHomePhone() {
    return homePhone;
  }

  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  public Contact workPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

   /**
   * 10 digit phone number, including area code, no formatting
   * @return workPhone
  **/
  @ApiModelProperty(value = "10 digit phone number, including area code, no formatting")
  public String getWorkPhone() {
    return workPhone;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  public Contact alternatePhone(String alternatePhone) {
    this.alternatePhone = alternatePhone;
    return this;
  }

   /**
   * 10 digit phone number, including area code, no formatting
   * @return alternatePhone
  **/
  @ApiModelProperty(value = "10 digit phone number, including area code, no formatting")
  public String getAlternatePhone() {
    return alternatePhone;
  }

  public void setAlternatePhone(String alternatePhone) {
    this.alternatePhone = alternatePhone;
  }

  public Contact mobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

   /**
   * 10 digit phone number, including area code, no formatting
   * @return mobilePhone
  **/
  @ApiModelProperty(value = "10 digit phone number, including area code, no formatting")
  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public Contact preferredPhone(String preferredPhone) {
    this.preferredPhone = preferredPhone;
    return this;
  }

   /**
   * 10 digit phone number, including area code, no formatting
   * @return preferredPhone
  **/
  @ApiModelProperty(value = "10 digit phone number, including area code, no formatting")
  public String getPreferredPhone() {
    return preferredPhone;
  }

  public void setPreferredPhone(String preferredPhone) {
    this.preferredPhone = preferredPhone;
  }

  public Contact preferredContactMethod(String preferredContactMethod) {
    this.preferredContactMethod = preferredContactMethod;
    return this;
  }

   /**
   * Contact method preference description
   * @return preferredContactMethod
  **/
  @ApiModelProperty(value = "Contact method preference description")
  public String getPreferredContactMethod() {
    return preferredContactMethod;
  }

  public void setPreferredContactMethod(String preferredContactMethod) {
    this.preferredContactMethod = preferredContactMethod;
  }

  public Contact fax(String fax) {
    this.fax = fax;
    return this;
  }

   /**
   * 10 digit fax number, including area code, no formatting
   * @return fax
  **/
  @ApiModelProperty(value = "10 digit fax number, including area code, no formatting")
  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public Contact email(String email) {
    this.email = email;
    return this;
  }

   /**
   * email address
   * @return email
  **/
  @ApiModelProperty(value = "email address")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact) o;
    return Objects.equals(this.homePhone, contact.homePhone) &&
        Objects.equals(this.workPhone, contact.workPhone) &&
        Objects.equals(this.alternatePhone, contact.alternatePhone) &&
        Objects.equals(this.mobilePhone, contact.mobilePhone) &&
        Objects.equals(this.preferredPhone, contact.preferredPhone) &&
        Objects.equals(this.preferredContactMethod, contact.preferredContactMethod) &&
        Objects.equals(this.fax, contact.fax) &&
        Objects.equals(this.email, contact.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(homePhone, workPhone, alternatePhone, mobilePhone, preferredPhone, preferredContactMethod, fax, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contact {\n");
    
    sb.append("    homePhone: ").append(toIndentedString(homePhone)).append("\n");
    sb.append("    workPhone: ").append(toIndentedString(workPhone)).append("\n");
    sb.append("    alternatePhone: ").append(toIndentedString(alternatePhone)).append("\n");
    sb.append("    mobilePhone: ").append(toIndentedString(mobilePhone)).append("\n");
    sb.append("    preferredPhone: ").append(toIndentedString(preferredPhone)).append("\n");
    sb.append("    preferredContactMethod: ").append(toIndentedString(preferredContactMethod)).append("\n");
    sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

