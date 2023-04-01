package com.ironhack.app.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.ironhack.app.models.*;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

} 

