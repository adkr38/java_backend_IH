package com.week5.app;
import java.util.Map;

class Student{
  protected String name;
  protected int grade;

  public Student(String name,int grade){
    setName(name);
    setGrade(grade);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }
  public static void increaseGrades(Map<String,Student> studentMap){
    for (Student st:studentMap.values()){
      double increasedGrade =  st.getGrade() * 1.1;
      int roundedGrade = increasedGrade>100?100:(int)Math.round(increasedGrade);
      st.setGrade(roundedGrade);
    }

  }
}
