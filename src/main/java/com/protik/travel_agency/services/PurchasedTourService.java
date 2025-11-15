package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.PurchasedTour;
import com.protik.travel_agency.entities.Tour;
import com.protik.travel_agency.models.PurchasedTourRequest;
import com.protik.travel_agency.repositories.PurchasedTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasedTourService {
    @Autowired
    private PurchasedTourRepository purchasedTourRepository;
    @Autowired
    private TourService tourService;

    public List<PurchasedTour> findAll() {
        return purchasedTourRepository.findAll();
    }

    public PurchasedTour findById(Long id) {
        return purchasedTourRepository.findById(id).orElseThrow();
    }

    public PurchasedTour create(PurchasedTourRequest purchasedTourRequest) {
        Tour tour = tourService.findById(purchasedTourRequest.getTourId());
        PurchasedTour purchasedTour = new PurchasedTour();
        purchasedTour.setTour(tour);
        purchasedTour.setAdults(purchasedTourRequest.getNumberOfAdults());
        purchasedTour.setChildren(purchasedTourRequest.getNumberOfChildren());
        Double price;
        price = purchasedTourRequest.getNumberOfAdults() * tour.getAdultPrice();
        price = price + purchasedTourRequest.getNumberOfChildren() * tour.getChildPrice();
        purchasedTour.setAmount(price);
        return purchasedTourRepository.save(purchasedTour);

    }

    public PurchasedTour update(PurchasedTour purchasedTour) {
        return null;
    }

}
