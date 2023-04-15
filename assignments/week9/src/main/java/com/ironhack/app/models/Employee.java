package com.ironhack.app.models;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironhack.app.enums.*;

@Entity
@Table(name="employees")
public class Employee{
  @Id
  @Column(name="employee_id")
  protected int employeeId;
  @Enumerated(EnumType.STRING)
  protected Department department;

  @JsonProperty("employee_name")
  protected String name;

  @Enumerated(EnumType.STRING)
  protected Status status;


  public Employee(int employeeId, Department department, String name, Status status){
    setEmployeeId(employeeId);
    setDepartment(department);
    setName(name);
    setStatus(status);
  }


public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
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

  public Employee(){};

}
