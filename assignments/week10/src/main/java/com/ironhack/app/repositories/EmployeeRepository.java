package com.ironhack.app.repositories;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ironhack.app.enums.*;
import com.ironhack.app.models.*;
import jakarta.persistence.*;
import org.springframework.data.repository.query.Param;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    

}
