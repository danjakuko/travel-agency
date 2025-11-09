package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent, String> {

}
