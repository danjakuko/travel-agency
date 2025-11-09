package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.PurchasedTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PurchasedTourRepository extends JpaRepository<PurchasedTour, Long> {

}
