package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.Airport;
import com.protik.travel_agency.entities.City;
import com.protik.travel_agency.static_data.AirportStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findByCityId(Long cityId);
    List<Airport> findByAirportStatus(AirportStatus status);
}
