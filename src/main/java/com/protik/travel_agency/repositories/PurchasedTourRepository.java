package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.AppUser;
import com.protik.travel_agency.entities.PurchasedTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PurchasedTourRepository extends JpaRepository<PurchasedTour, Long> {
    List<PurchasedTour> findByAppUser(AppUser user);
    List<PurchasedTour> findByTour_Id(Long id);
}
