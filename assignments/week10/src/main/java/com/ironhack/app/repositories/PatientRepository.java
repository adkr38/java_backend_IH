package com.ironhack.app.repositories;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ironhack.app.models.*;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>{

}

