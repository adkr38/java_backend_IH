package com.ironhack.app.controllers;
import com.ironhack.app.repositories.*;
import com.ironhack.app.models.*;
import java.util.List; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/students")
public class StudentController{
  @Autowired
  private StudentRepository studentRepository;

  @GetMapping("")
  public List<Student> getStudents(){
    return studentRepository.findAll();
  }

  @GetMapping("/hw")
  public String  getHelloWorld(){
    return "<h1>Hello world!</h1>";
  }

  @PostMapping("/addStudent")
  public Student addStudent(@RequestBody Student student){
    System.out.println(student.getFirstName());
    return studentRepository.save(student);
  }

  @PostMapping("/addStudents")
  public List<Student> addStudents(@RequestBody List<Student> students){
    return studentRepository.saveAll(students);
  }
}



