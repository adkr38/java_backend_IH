package com.ironhack.eigth_week.models;
import jakarta.persistence.*;
import java.util.List;

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

  @ManyToMany(mappedBy = "students")
  @JoinTable(
  name="student_spells",
  joinColumns = @JoinColumn(name = "student_id"),
  inverseJoinColumns = @JoinColumn(name="spell_id"))
  private List<Spell> spells;

  public Student(String firstName, String lastName, List<Spell> spells){
    setFirstName(firstName);
    setLastName(lastName);
  }

  public List<Spell> getSpells() {
    return spells;
  }

  public void setSpells(List<Spell> spells) {
    this.spells = spells;
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
