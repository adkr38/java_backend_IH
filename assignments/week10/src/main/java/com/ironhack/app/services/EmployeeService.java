package com.ironhack.app.services;
import java.util.Optional;
import java.lang.reflect.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ironhack.app.models.*;
import com.ironhack.app.repositories.*;

@Service
public class EmployeeService{

  @Autowired
  EmployeeRepository employeeRepository;

  public boolean save(Employee employee){
    Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
    if (optionalEmployee.isPresent()){
      return false;
    }

    employeeRepository.save(employee);
    return true;
  }

  public int update(int id, Employee employee){
    Optional<Employee> optionalEmployee = employeeRepository.findById(id);
    if (optionalEmployee.isEmpty()){
      employeeRepository.save(employee);
      return 1;
    }
    employee.setId(id);
    employeeRepository.save(employee);
    return 0;

  }

  public <T> boolean updateEmployeeAttr(int id, String attr, T updatedAttr){
    Optional<Employee> optionalEmployee = employeeRepository.findById(id);
    if (optionalEmployee.isEmpty()){
      return false;
    }

    Employee employee = optionalEmployee.get();

    try{
      Field field = Employee.class.getDeclaredField(attr);
      field.setAccessible(true);
      field.set(employee, (T)updatedAttr);

    }catch(NoSuchFieldException | IllegalAccessException e){
      return false;
    }

    employeeRepository.save(employee);
    return true;


  }


}
