package com.ironhack.app.models;

import jakarta.persistence.*;

@Entity
@Table(name="contacts")
@AttributeOverride(name="firstName",column = @Column(name="first_name"))
@AttributeOverride(name="lastName",column = @Column(name="last_name"))
@AttributeOverride(name="middleName",column = @Column(name="middle_name"))
@AttributeOverride(name="salutation",column = @Column(name="salutation"))
public class Contact{

  @Embedded
  private Name name;

  private String title;

  private String company;

  public Contact(Name name, String title, String company){
    setName(name);
    setTitle(title);
    setCompany(company);
  }

  public Name getName() {
	return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public Contact(){};
}

