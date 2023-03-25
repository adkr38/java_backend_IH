package com.week5.app;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main( String[] args ){
      Map<String,Student>studentsMap = new HashMap<String,Student>();
      Student student1 = new Student("Adrian", 50);
      Student student2 = new Student("David", 92);
      Student student3 = new Student("Jhon", 33);
      Student student4 = new Student("Alex", 10);
      Student[] myStudents = new Student[4];
      myStudents[0] = student1;
      myStudents[1] = student2;
      myStudents[2] = student3;
      myStudents[3] = student4;
      for (Student st:myStudents){
      studentsMap.put(st.getName(),st);
    }

    }
    
    
}
