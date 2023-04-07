package com.ironhack.app.models;

import jakarta.persistence.*;

@Entity
@Table(name="main")
class FlightBooking{
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  @Id
  protected int bookingId;

  @Column(name="flight_id")
  protected int flightId;

  @Column(name="customer_id")
  protected int customerId;


  public FlightBooking(int customerId, int flightId){
    setCustomerId(customerId);
    setFlightId(flightId);
  }

  public int getBookingId() {
    return bookingId;
  }


  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public int getFlightId() {
    return flightId;
  }

  public void setFlightId(int flightId) {
    this.flightId= flightId;
  }

  public FlightBooking(){};

}
