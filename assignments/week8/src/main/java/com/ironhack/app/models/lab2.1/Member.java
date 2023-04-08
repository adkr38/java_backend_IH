package com.ironhack.app.models;
import jakarta.persistence.*;
import java.time.LocalDate;
import com.ironhack.app.enums.*;



@Embeddable
public class Member{
  protected String name;
  @Enumerated(EnumType.STRING)
  protected Status status;
  protected LocalDate renewalDate;


  public Member(String name, Status status, LocalDate renewalDate){
    setName(name);
    setStatus(status);
    setRenewalDate(renewalDate);


  }

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public Status getStatus() {
    return status;
  }


  public void setStatus(Status status) {
    this.status = status;
  }


  public LocalDate getRenewalDate() {
    return renewalDate;
  }


  public void setRenewalDate(LocalDate renewalDate) {
    this.renewalDate = renewalDate;
  }

  public Member(){}


}
