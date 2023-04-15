package com.ironhack.app.repositories;
import com.ironhack.app.models.Employee;
import com.ironhack.app.enums.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;



public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
  List<Employee> findAll();
  Optional<Employee> findById(int id);
  List<Employee> findByStatus(Status status);
  List<Employee> findByDepartment(Department department);

}
