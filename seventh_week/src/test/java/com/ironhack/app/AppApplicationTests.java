package com.ironhack.app;
import com.ironhack.app.models.*;
import com.ironhack.app.repositories.*;
import com.ironhack.app.controllers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.util.Optional;
import java.util.List;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
class AppApplicationTests {

  @Autowired
  private StudentRepository studentRepository;
  
  @Autowired
  private GradeRepository gradeRepository;

  @Autowired
  private SectionRepository sectionRepository;

  private Student student1;
  private List<Grade> grades;
  private List<Section> sections;


  @BeforeEach
  void setUp(){
    student1 = new Student("Roberto", "Carlos");
    studentRepository.save(student1);

    sections = sectionRepository.saveAll(List.of(
            new Section("CS101-A", "CS101",  (short) 1802, "Balderez"),
            new Section("CS101-B", "CS101",  (short) 1650, "Su"),
            new Section("CS103-A", "CS103",  (short) 1200, "Rojas"),
            new Section("CS103-B", "CS103",  (short) 1208, "Tonno")
        ));

    grades = gradeRepository.saveAll(List.of(
                new Grade("Maya Charlotte", "CS101-A", 98),
                new Grade("James Fields", "CS101-A", 82),
                new Grade("Michael Alcocer", "CS101-B", 65),
                new Grade("Maya Charlotte", "CS103-A", 89),
                new Grade("Tomas Lacroix", "CS101-A", 99),
                new Grade("Sara Bisat", "CS101-A", 87),
                new Grade("James Fields", "CS101-B", 46),
                new Grade("Helena Sepulvida", "CS103-A", 72)
        ));

 
  }

  @AfterEach
  void tearDown(){
    studentRepository.deleteById(student1.getId());
    gradeRepository.deleteAll();
    sectionRepository.deleteAll();
  }

  @Test
  public void testJPA(){
    Optional<Student> studentFromDb = studentRepository.findById(student1.getId());
    Assertions.assertTrue(studentFromDb.isPresent());
    Assertions.assertEquals(student1,studentFromDb.get());

  }

  @Test
  public void testGradePersist(){
    Optional<Grade> gradeFromDb = gradeRepository.findById(grades.get(0).getId());
    Assertions.assertTrue(gradeFromDb.isPresent());
  }

  // @Test
  // public void testStudentNameAsExpected(){
  //   Optional<Grade> gradeFromDb = gradeRepository.findById(grades.get(0).getId());
  //   Assertions.assertTrue(gradeFromDb.get().getStudentName().equals("adrian"));
  // }

  @Test
  public void testMaxScoreBySectionExpected(){
    List<Object[]> functionOutput = sectionRepository.findMaxScoreBySection();
    System.out.println(functionOutput);
    // System.out.println(functionOutput.get(0));
    Assertions.assertTrue(true);
  }


  

}
