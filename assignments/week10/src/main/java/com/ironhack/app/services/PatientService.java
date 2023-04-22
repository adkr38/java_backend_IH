package com.ironhack.app.services;
import org.springframework.stereotype.Service;
import com.ironhack.app.repositories.*;
import com.ironhack.app.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class PatientService{

  @Autowired
  private PatientRepository patientRepository;
  @Autowired
  private EmployeeRepository employeeRepository;


  public void save(Patient patient){
    Employee admittedBy = patient.getAdmittedBy();
    Optional<Employee> potentialEmployee = employeeRepository.findById(admittedBy.getId());
    if (potentialEmployee.isEmpty()){
      employeeRepository.save(admittedBy);
    }
  }

  public int update(int id, Patient patient){
    int modified = 0;

    Optional<Patient> optionalPatient = patientRepository.findById(id);
    if (optionalPatient.isPresent()){
      patient.setId(id);
    }
    Employee admittedBy = patient.getAdmittedBy();
    Optional<Employee> optionalEmployee = employeeRepository.findById(admittedBy.getId());
    if (optionalEmployee.isEmpty()){
      employeeRepository.save(admittedBy);
      modified++;
    }

    patientRepository.save(patient);
    return modified;
  }

}
