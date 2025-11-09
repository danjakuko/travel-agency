package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
Boolean existsByName (String name);
}
