package com.ironhack.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.ironhack.app.repositories.*;
import com.ironhack.app.models.*;
import com.ironhack.app.enums.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@RestController
@RequestMapping("/patients")
class PatientController{

  @Autowired
  PatientRepository patientRepository;


  // Practicando un poco response entity.
  @GetMapping("/")
  ResponseEntity<List<Patient>> findAll(){
    List<Patient> patients = patientRepository.findAll();
    if (!(patients.size() > 0)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(patients);
  }

  @GetMapping("/{id}")
  ResponseEntity<Patient> findById(@PathVariable int id){
    Optional<Patient> optionalPatient = patientRepository.findById(id);
    if (!optionalPatient.isPresent()){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(optionalPatient.get());
  }


  /**
 * ISO-8601 YYYY-MM-DD format.
 * @param startDate
 * @param endDate
 * @return
 */
@GetMapping("/date-range")
  List<Patient> findByDateRange(@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate){
    LocalDate datedStart = LocalDate.parse(startDate);
    LocalDate datedFinish = LocalDate.parse(endDate);
    return patientRepository.findPatientsByDateOfBirthRange(datedStart, datedFinish);
  }

  @GetMapping("/department")
  List<Patient> findByDepartment(@RequestParam(defaultValue = "cardiology") String department) {
      return patientRepository.findPatientsByAdmittingDoctorDepartment(Department.valueOf(department.toLowerCase()));
  }

@GetMapping("/status")
List<Patient> findByEmployeeStatus(@RequestParam(defaultValue = "OFF") String status) {
    return patientRepository.findPatientsByAdmittingDoctorStatus(Status.valueOf(status.toUpperCase()));
}

}
