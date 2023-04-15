package com.ironhack.app.repositories;
import com.ironhack.app.models.*;
import com.ironhack.app.enums.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("SELECT p FROM Patient p WHERE p.patientId = :patientId")
    Patient findPatientById(@Param("patientId") int patientId);

    @Query("SELECT p FROM Patient p WHERE p.dateOfBirth BETWEEN :startDate AND :endDate")
    List<Patient> findPatientsByDateOfBirthRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.department = :department")
    List<Patient> findPatientsByAdmittingDoctorDepartment(@Param("department") Department department);

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.status = :status")
    List<Patient> findPatientsByAdmittingDoctorStatus(@Param("status") Status status);
}
