package com.ironhack.app.models;

import jakarta.persistence.*;

@Entity
@Table(name="flights")
public class Flight{
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  @Id
  protected int flightId;

  @Column(name="flight_number")
  protected  String flightNumber;

  protected String aircraft;

  @Column(name="flight_mileage")
  protected int flightMileage;

  @Column(name="aircraft_seats")
  protected int totalAircraftSeats;

  public Flight(String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage){
    setFlightNumber(flightNumber);
    setAircraft(aircraft);
    setTotalAircraftSeats(totalAircraftSeats);
    setFlightMileage(flightMileage);
  }

  public void setFlightMileage(int flightMileage){
    this.flightMileage = flightMileage;
  }

  public int getFlightMileage(){
    return flightMileage;
  }

  public int getFlightId() {
    return flightId;
  }


  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getAircraft() {
    return aircraft;
  }

  public void setAircraft(String aircraft) {
    this.aircraft = aircraft;
  }

  public int getTotalAircraftSeats() {
    return totalAircraftSeats;
  }

  public void setTotalAircraftSeats(int totalAircraftSeats) {
    this.totalAircraftSeats = totalAircraftSeats;
  }

  public Flight(){};

}
