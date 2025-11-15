package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Boolean existsByName(String name);

    List<Country> findAllByNameContainsIgnoreCase(String name);

    List<Country> findByContinent_Name(String name);
}
