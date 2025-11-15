package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.Airport;
import com.protik.travel_agency.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findByCity(City city);
    List<Airport> findByCityId(Long cityId);
    List<Airport> findByCityName(String cityName);
}
