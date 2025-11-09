package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {

}
