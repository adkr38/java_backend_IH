package com.ironhack.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ironhack.app.repositories.*;
import com.ironhack.app.services.PatientService;
import jakarta.validation.Valid;
import com.ironhack.app.dtos.*;
import com.ironhack.app.models.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/patients")
class PatientController{

  @Autowired
  private PatientRepository patientRepository;
  private EmployeeRepository employeeRepository;

  @Autowired
  private PatientService patientService;

  @PostMapping("/add")
  private ResponseEntity<ResponseDTO> addPatient(@RequestBody @Valid Patient patient){
    patientService.save(patient);
    return ResponseEntity.ok().body(new SuccessDTO<>(200, "success", List.of(patient)));

  }

  @PutMapping("/update/{id}")
  private ResponseEntity<ResponseDTO> updatePatient(@PathVariable int id, @RequestBody @Valid Patient patient){
    try{
    int modified = patientService.update(id,patient);
    int statusCode = modified == 0?200:201;
    String message = modified == 0?"Resource successfully updated.":"Resource successfully created.";
    return ResponseEntity.ok().body(new SuccessDTO<>(statusCode, message, List.of(patient)));
    }catch(Error e){
      return ResponseEntity.badRequest().body(new ErrorDTO(400, e.getMessage()));
    }
  }
}
