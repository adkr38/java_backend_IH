package com.ironhack.app.controllers;
import com.ironhack.app.models.*;
import com.ironhack.app.repositories.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

class FlightController{
  @Autowired
  FlightRepository flightRepository;

  List<Flight> findFlightContainsBoeing(){
    return flightRepository.findFlightByAircraftLike("Boeing");
  }

  Optional<Flight> findFlightByFlightNumber(String flightNumber){
    return flightRepository.findFlightByFlightNumber(flightNumber);
  }
}

