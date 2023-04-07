package com.ironhack.app.repositories;
import com.ironhack.app.models.*;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;


@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer>{
  @Query(value="""
  SELECT * FROM flights
  WHERE flight_number = :flightNumber
  """,nativeQuery=true)
  Optional<Flight> findFlightByFlightNumber(@Param("flightNumber") String flightNumber);

  @Query(value = """
  SELECT * FROM flights
  WHERE aircraft LIKE %:aircraftName%
  """,nativeQuery = true)
  List<Flight> findFlightByAircraftLike(@Param("aircraftName") String aircraft);

  List<Flight> findFlightByFlightMileageGreaterThan(int flightMileage);
   


}
