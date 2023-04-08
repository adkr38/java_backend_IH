package com.ironhack.app.models;
import jakarta.persistence.Embeddable;

@Embeddable
public class Name{
  private String firstName;
  private String lastName;
  private String middleName;
  private String salutation;

  public Name(String firstName, String lastName, String middleName, String salutation){
    setFirstName(firstName);
    setLastName(lastName);
    setMiddleName(middleName);
    setSalutation(salutation);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  Name(){};


}
