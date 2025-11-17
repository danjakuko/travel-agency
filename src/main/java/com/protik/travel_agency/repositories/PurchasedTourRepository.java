package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.AppUser;
import com.protik.travel_agency.entities.PurchasedTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public interface PurchasedTourRepository extends JpaRepository<PurchasedTour, Long> {
    List<PurchasedTour> findByAppUserOrderByPurchaseDateDesc(AppUser appUser);
    List<PurchasedTour> findByTour_Id(Long id);
    List<PurchasedTour> findAllByPurchaseDateAfter(LocalDateTime purchaseDateAfter);
}
