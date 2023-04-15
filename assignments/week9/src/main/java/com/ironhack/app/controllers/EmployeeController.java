package com.ironhack.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ironhack.app.repositories.*;
import com.ironhack.app.models.*;
import com.ironhack.app.enums.*;
import com.ironhack.app.dto.*;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/employees")
class EmployeeController{

  @Autowired
  EmployeeRepository employeeRepository;

  @GetMapping("/")
  ResponseEntity<SuccessDTO<Employee>> findAll(){
    List<Employee> queryResult = employeeRepository.findAll();
    SuccessDTO<Employee> successDTO = new SuccessDTO<Employee>("success",200,queryResult);
    return ResponseEntity.status(200).body(successDTO);
  }

  @GetMapping("/{id}")
  ResponseEntity<? extends ResponseDTO> findById(@PathVariable int id){
    Optional<Employee> queryResult = employeeRepository.findById(id);
    if (queryResult.isEmpty()){
      ErrorDTO error =  new ErrorDTO(404, "id not found");
      return ResponseEntity.status(404).body(error);
    }
    SuccessDTO<Employee> success = new SuccessDTO<>("success", 200, List.of(queryResult.get()));
    return ResponseEntity.status(200).body(success);
  }

  @GetMapping("/status")
  ResponseEntity<SuccessDTO<Employee>> findByStatus(@RequestParam(defaultValue = "OFF") String status){
    List<Employee> queryResult = employeeRepository.findByStatus(Status.valueOf(status));
    SuccessDTO<Employee> success = new SuccessDTO<Employee>("success", 200, queryResult);
    return ResponseEntity.status(200).body(success);
  }

  @GetMapping("/department")
  ResponseEntity<SuccessDTO<Employee>> findByDepartment(@RequestParam(defaultValue = "cardiology") String department){
    List<Employee> queryResult = employeeRepository.findByDepartment(Department.valueOf(department));
    SuccessDTO<Employee> success = new SuccessDTO<Employee>("success", 200, queryResult);
    return ResponseEntity.status(200).body(success);
  }


}
