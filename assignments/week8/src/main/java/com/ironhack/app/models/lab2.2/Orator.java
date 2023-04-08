package com.ironhack.app.models;
import jakarta.persistence.Embeddable;

@Embeddable
public class Orator{
  protected String name;
  protected float presentationDuration;

  public Orator(String name,float presentationDuration){
    setName(name);
    setPresentationDuration(presentationDuration);

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPresentationDuration() {
    return presentationDuration;
  }

  public void setPresentationDuration(float presentationDuration) {
    this.presentationDuration = presentationDuration;
  }

  public Orator(){};


}
