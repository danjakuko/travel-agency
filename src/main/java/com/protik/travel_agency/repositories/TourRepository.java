package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long>, JpaSpecificationExecutor<Tour> {
    List<Tour> findAllByFromAirport_Id(Long airportId);

    List<Tour> findAllByToAirport_Id(Long toAirportId);

    List<Tour> findAllByFromCity_Id(Long cityId);

    List<Tour> findAllByToCity_Id(Long cityId);

    List<Tour> findAllByToHotel_Id(Long hotelId);

    List<Tour> findAllByNameContainsIgnoreCase(String name);

    @Query("select t from Tour t where t.toCity.country.id = :countyId")
    List<Tour> findAllByCountry(Long countryId);

    @Query("select t from Tour t where t.toCity.country.continent.name = :continentName")
    List<Tour> findAllByContinent(String continentName);
}
