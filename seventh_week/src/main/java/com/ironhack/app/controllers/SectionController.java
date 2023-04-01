package com.ironhack.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.ironhack.app.repositories.GradeRepository;
import com.ironhack.app.repositories.SectionRepository;
import com.ironhack.app.models.*;
import jakarta.persistence.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/section")
class SectionController{

  @Autowired
  SectionRepository sectionRepository;

  @GetMapping
  public List<Section> findAll(){
    return sectionRepository.findAll();
  }

  @GetMapping("/maxBySection")
  public List<Object[]> findMaxScoreBySection() {
     return sectionRepository.findMaxScoreBySection();
   }

}
