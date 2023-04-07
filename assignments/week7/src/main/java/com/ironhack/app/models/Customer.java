package com.ironhack.app.models;
import com.ironhack.app.enums.*;
import jakarta.persistence.*;

@Entity
@Table(name="customers")
public class Customer{

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  @Id
  protected int customerId;

  @Column(name="customer_name")
  protected String customerName;

  @Column(name="customer_status")
  @Enumerated(EnumType.STRING)
  protected CustomerStatus customerStatus;

  @Column(name="customer_mileage")
  protected int totalCustomerMileage;

  public Customer(String customerName, CustomerStatus customerStatus, int totalCustomerMileage){
    setCustomerName(customerName);
    setCustomerStatus(customerStatus);
    setTotalCustomerMileage(totalCustomerMileage);

  }

  public int getCustomerId() {
    return customerId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public CustomerStatus getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(CustomerStatus customerStatus) {
    this.customerStatus = customerStatus;
  }

  public int getTotalCustomerMileage() {
    return totalCustomerMileage;
  }

  public void setTotalCustomerMileage(int totalCustomerMileage) {
    this.totalCustomerMileage = totalCustomerMileage;
  }

  public Customer(){};

}
