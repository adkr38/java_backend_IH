package com.ironhack.app.models;
import java.time.LocalDate;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="patients")
public class Patient{

  @Id
  @Column(name="patient_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int patientId;

  @JsonProperty("patient_name")
  protected String name;

  @Column(name="date_of_birth")
  protected LocalDate dateOfBirth;

  @ManyToOne
  @JoinColumn(name="admitted_by",referencedColumnName = "employee_id")
  protected Employee admittedBy;

  public Patient(String name, LocalDate dateOfBirth,Employee admittedBy){
    setName(name);
    setDateOfBirth(dateOfBirth);
    setAdmittedBy(admittedBy);
  }

  public int getPatientId() {
    return patientId;
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
  public Patient(){};


}
