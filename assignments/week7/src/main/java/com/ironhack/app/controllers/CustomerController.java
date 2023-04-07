package com.ironhack.app.controllers;
import com.ironhack.app.models.*;
import com.ironhack.app.repositories.*;
import com.ironhack.app.enums.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

class CustomerController{
  @Autowired
  CustomerRepository customerRepository;

  Optional<Customer> findByCustomerName(String customerName){
    return customerRepository.findByCustomerName(customerName);
  }

  List<Customer> findByCustomerStatus(CustomerStatus customerStatus){
    return customerRepository.findByCustomerStatus(customerStatus);
  }



}
