package com.ironhack.app;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ironhack.app.models.*;
import com.ironhack.app.enums.*;
import com.ironhack.app.repositories.*;
import java.util.Optional;
import java.util.List;

@SpringBootTest
class AppApplicationTests {
  Customer myCustomer;
  Flight myFlight;

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  FlightRepository flightRepository;


  @BeforeEach
  void setUp(){
    myCustomer = new Customer("Adrian",CustomerStatus.Gold, 900);
    myFlight = new Flight("TFN2", "Boeing", 83,100);
    customerRepository.save(myCustomer);
    flightRepository.save(myFlight);
  }

  @AfterEach
  void tearDown(){
    customerRepository.deleteById(myCustomer.getCustomerId());
    flightRepository.deleteById(myFlight.getFlightId());
  }

  @Test
  void testCustomerPersists(){
    Optional<Customer> customerFromDb = customerRepository.findById(myCustomer.getCustomerId());
    Assertions.assertTrue(customerFromDb.isPresent());
  }

  @Test
  void testFlightPersists(){
    Optional<Flight> flightFromDb = flightRepository.findById(myFlight.getFlightId());
    Assertions.assertTrue(flightFromDb.isPresent());
  }

  @Test
  void testFindCustomerByNameFindsAdrian(){
    Optional<Customer> customerAdrian = customerRepository.findByCustomerName("Adrian");
    Assertions.assertTrue(customerAdrian.isPresent());
  }

  @Test
  void testFindFlightByFlightNumberFindsId1(){
    Optional<Flight> flight1 = flightRepository.findFlightByFlightNumber("DL143");
    Assertions.assertTrue(flight1.isPresent());
    Flight flightObject = flight1.get();
    Assertions.assertEquals(1, flightObject.getFlightId());
  }

  @Test
  void testFindBoeingFlights(){
    List<Flight> boeingFlights = flightRepository.findFlightByAircraftLike("Boeing");
    Assertions.assertEquals(5,boeingFlights.size());
  }

  @Test 
  void testFindFlightsWithMileageGreater(){
    List<Flight> longFlights = flightRepository.findFlightByFlightMileageGreaterThan(500);
    Assertions.assertEquals(4,longFlights.size());

  }





}
