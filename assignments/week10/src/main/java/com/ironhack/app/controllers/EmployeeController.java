package com.ironhack.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ironhack.app.repositories.*;
import com.ironhack.app.services.EmployeeService;
import jakarta.validation.Valid;
import com.ironhack.app.dtos.*;
import com.ironhack.app.models.*;
import com.ironhack.app.enums.*;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
class EmployeeController{

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/")
  private ResponseEntity<ResponseDTO> findAll(){
    try{
    return ResponseEntity.ok().body(new SuccessDTO<>(200, "Success.", employeeRepository.findAll()));
    } catch(Error e){
    return ResponseEntity.ok().body(new ErrorDTO(400, e.getMessage()));

    }

  }

  @PostMapping("/add")
  private ResponseEntity<ResponseDTO> addEmployee(@RequestBody @Valid Employee employee){
    boolean success = employeeService.save(employee);
    if (success){
      return ResponseEntity.ok().body(new SuccessDTO<>(200, "Resource added successfully.", List.of(employee)));
    }

    return ResponseEntity.ok().body(new ErrorDTO(409, "Resource already exists."));

  }

  @PutMapping("/update/{id}")
  private ResponseEntity<ResponseDTO> updateEmployee(@PathVariable int id, @RequestBody @Valid Employee employee){
    try{
      int modified = employeeService.update(id,employee);
      int statusCode = modified == 0?200:201;
      String message = modified == 0?"Resource successfully updated.":"Resource successfully created.";
      return ResponseEntity.ok().body(new SuccessDTO<>(statusCode, message, List.of(employee)));
    }catch(Error e){
      return ResponseEntity.badRequest().body(new ErrorDTO(400, e.getMessage()));
    }
  }

  @PatchMapping("/updateDepartment/{id}")
  private ResponseEntity<ResponseDTO> updateDepartment(@PathVariable int id, @RequestBody @Valid Map<String,String>department){
    for (String key: new HashSet<>(department.keySet())){
      String val = department.remove(key);
      department.put(key.toLowerCase(), val);
    }
    if (!(department.containsKey("department"))){
      return ResponseEntity.badRequest().body(new ErrorDTO(400, "Department not found on request body."));

    }
    try{
      boolean updatedAttr = employeeService.updateEmployeeAttr(id, "department", Department.valueOf(department.get("department")));
      if (updatedAttr){
        return ResponseEntity.ok().body(new SuccessDTO<>(200, "Department updated successfully.", List.of(employeeRepository.findById(id))));
      }

      return ResponseEntity.badRequest().body(new SuccessDTO<>(404, "Resource doesn't exist.", List.of()));

    }catch (Error e){
      return ResponseEntity.badRequest().body(new ErrorDTO(400, e.getMessage()));
    }

  }

  @PatchMapping("/updateStatus/{id}")
  private ResponseEntity<ResponseDTO> updateStatus(@PathVariable int id, @RequestBody Map<String,String> status){
    for (String key: new HashSet<>(status.keySet())){
      String val = status.remove(key);
      status.put(key.toLowerCase(), val);
    }
    if (!(status.containsKey("status"))){
      return ResponseEntity.badRequest().body(new ErrorDTO(400, "Status not found on request body."));

    }
    try{
      boolean updatedAttr = employeeService.updateEmployeeAttr(id, "status", Status.valueOf(status.get("status")));
      if (updatedAttr){
        return ResponseEntity.ok().body(new SuccessDTO<>(200, "Status updated successfully.", List.of(employeeRepository.findById(id))));
      }

      return ResponseEntity.badRequest().body(new SuccessDTO<>(404, "Resource doesn't exist.", List.of()));

    }catch (Error e){
      return ResponseEntity.badRequest().body(new ErrorDTO(400, e.getMessage()));
    }

  }


}
