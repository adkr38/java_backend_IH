package com.ironhack.app.models;
import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student{
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name="first_name")
  private String firstName;
  @Column(name="last_name")
  private String lastName;

  public Student(String firstName, String lastName){
    setFirstName(firstName);
    setLastName(lastName);
  }
  public int getId(){
    return id;
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

  @Override
  public boolean equals(Object other){
    if (!(other instanceof Student)){
      return false;
    }
    Student otherStudent = (Student) other;
    return getId() == otherStudent.getId();
  }

  @Override
  public int hashCode(){
    return getFirstName().hashCode() +  getId() + getLastName().hashCode();
  }

  public Student(){}

}
