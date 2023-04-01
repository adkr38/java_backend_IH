package com.ironhack.app.models;
import jakarta.persistence.*;

@Entity
@Table(name="grade")
public class Grade{

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  protected int id;

  @Column(name="student_name")
  protected String studentName;

  @Column(name="section_id")
  protected String sectionId;

  protected int score;

  public Grade(String studentName, String sectionId, int score){
    setStudentName(studentName);
    setSectionId(sectionId);
    setScore(score);
  }

  public int getId() {
    return id;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getSectionId() {
    return sectionId;
  }

  public void setSectionId(String sectionId) {
    this.sectionId = sectionId;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public Grade(){}

}
