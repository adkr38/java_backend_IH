package com.ironhack.app.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironhack.app.enums.*;
import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee{

  @Id
  @Column(name="employee_id")
  protected int id;

  @Enumerated(EnumType.STRING)
  protected Department department; 

  protected String name;

  @Enumerated(EnumType.STRING)
  protected Status status;

  public Employee(int id, Department department, String name, Status status){
    setId(id);
    setDepartment(department);
    setName(name);
    setStatus(status);

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
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

  Employee(){}

}
