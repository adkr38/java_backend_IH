package com.ironhack.app.models;
import jakarta.persistence.*;

@Entity
@Table(name="section")
public class Section{
  @Id
  protected String id;

  @Column(name="course_code")
  protected String courseCode;
  @Column(name="room_num")
  protected int roomNum;

  protected String instructor;

  public Section(String id, String courseCode, int roomNum, String instructor){
    setId(id);
    setCourseCode(courseCode);
    setRoomNum(roomNum);
    setInstructor(instructor);
  }

  public void setId(String id){
    this.id = id;
  }

  public String getId() {
    return id;
  }


  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public int getRoomNum() {
    return roomNum;
  }

  public void setRoomNum(int roomNum) {
    this.roomNum = roomNum;
  }

  public String getInstructor() {
    return instructor;
  }

  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

  public Section(){}

}
