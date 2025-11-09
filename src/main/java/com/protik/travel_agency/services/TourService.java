package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.Tour;
import com.protik.travel_agency.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public Tour findById(Long id) {
        return tourRepository.findById(id).orElseThrow(()-> new RuntimeException("Tour not found"));
    }

}
