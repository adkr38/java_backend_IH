package com.ironhack.app.models;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="patients")
public class Patient{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="patient_id")
  protected int id;

  @NotEmpty(message="Please input a valid product name.")
  protected String name;

  @Column(name="date_of_birth")
  protected LocalDate dateOfBirth;

  @ManyToOne
  @JoinColumn(name="admitted_by",referencedColumnName = "employee_id")
  @NotNull
  protected Employee admittedBy;

  public Patient(String name, LocalDate dateOfBirth, Employee admittedBy){
    setName(name);
    setDateOfBirth(dateOfBirth);
    setAdmittedBy(admittedBy);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Employee getAdmittedBy() {
    return admittedBy;
  }

  public void setAdmittedBy(Employee admittedBy) {
    this.admittedBy = admittedBy;
  }

  public Patient(){}

}
