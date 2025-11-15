package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByNameContainsIgnoreCase(String name);

    List<City> findAllByCountry_Id(Long countryId);
}
