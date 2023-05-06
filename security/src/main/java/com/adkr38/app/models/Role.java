package com.adkr38.app.models;
import jakarta.persistence.*;

@Entity
public class Role{

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private long id;

  private String name;

  public Role(String name){
    setName(name);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Role(){};


}
