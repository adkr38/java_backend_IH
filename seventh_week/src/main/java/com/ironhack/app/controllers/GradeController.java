package com.ironhack.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.ironhack.app.repositories.GradeRepository;
import com.ironhack.app.models.*;
import jakarta.persistence.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/grade")
class GradeController{
  @Autowired
  GradeRepository gradeRepository;

  @GetMapping
  List<Grade> findAll(){
    return gradeRepository.findAll();

  }

  @GetMapping("/greaterThan50")
  List<Grade> findStudentsWithScoreGreaterThan50(){
    return gradeRepository.findByScoreGreaterThan(50);
  }

  @GetMapping("/greaterThan70")
  List<Grade> findStudentsWithScoreGreaterThan70SortedByName(){
    return gradeRepository.findByScoreGreaterThanOrderByStudentNameAsc(70);
  }

  @GetMapping("/studentsNotInSection")
  List<Grade> findStudentsWhereSectionIdNot(@RequestBody String sectionId){
    return gradeRepository.findBySectionIdNot(sectionId);
  }


  

}
