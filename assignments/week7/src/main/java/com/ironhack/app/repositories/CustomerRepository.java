package com.ironhack.app.repositories;
import com.ironhack.app.models.*;
import com.ironhack.app.enums.*;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
  Optional<Customer> findByCustomerName(String customerName);
  List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}
