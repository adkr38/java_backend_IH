package com.ironhack.app.models; 
import jakarta.persistence.*;
import com.ironhack.app.enums.*; 

@Embeddable
public class Guest{

  protected String name;

  @Enumerated(EnumType.STRING)
  protected InvitationStatus status;

  public Guest(String name,InvitationStatus status){
    setName(name);
    setStatus(status);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InvitationStatus getStatus() {
    return status;
  }

  public void setStatus(InvitationStatus status) {
    this.status = status;
  }

  public Guest(){};

}
