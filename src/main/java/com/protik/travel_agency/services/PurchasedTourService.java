package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.AppUser;
import com.protik.travel_agency.entities.PurchasedTour;
import com.protik.travel_agency.entities.Tour;
import com.protik.travel_agency.models.PurchasedTourRequest;
import com.protik.travel_agency.repositories.PurchasedTourRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchasedTourService {
    @Autowired
    private PurchasedTourRepository purchasedTourRepository;
    @Autowired
    private TourService tourService;
    @Autowired
    private UserService userService;

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
        purchasedTour.setPurchaseDate(LocalDateTime.now());
        int numberOfSeatsRequest = purchasedTourRequest.getNumberOfAdults()+purchasedTourRequest.getNumberOfChildren();
        if (tour.getNumberOfSeats() < numberOfSeatsRequest) {
            throw new IllegalArgumentException("Not enough seats available for this tour.");
        }
        tour.setNumberOfSeats(tour.getNumberOfSeats() - purchasedTourRequest.getNumberOfAdults() - purchasedTourRequest.getNumberOfChildren());
        tourService.flush(tour);
        Double price;
        price = purchasedTourRequest.getNumberOfAdults() * tour.getAdultPrice();
        price = price + purchasedTourRequest.getNumberOfChildren() * tour.getChildPrice();
        purchasedTour.setTotalAmount(price);
        return purchasedTourRepository.save(purchasedTour);

    }

    public PurchasedTour update(Long purchasedTourId, PurchasedTourRequest updatedRequest) {
        PurchasedTour existingPurchase = purchasedTourRepository.findById(purchasedTourId)
                .orElseThrow(() -> new RuntimeException("Purchased tour not found"));
        Tour tour = existingPurchase.getTour();
        int oldTotalSeats = existingPurchase.getAdults() + existingPurchase.getChildren();
        int newTotalSeats = updatedRequest.getNumberOfAdults() + updatedRequest.getNumberOfChildren();
        int seatDifference = newTotalSeats - oldTotalSeats;
        int updatedSeats = tour.getNumberOfSeats() - seatDifference;
        if (updatedSeats < 0) {
            throw new IllegalArgumentException("Not enough seats available for this tour.");
        }
        tour.setNumberOfSeats(updatedSeats);
        tourService.flush(tour);
        existingPurchase.setAdults(updatedRequest.getNumberOfAdults());
        existingPurchase.setChildren(updatedRequest.getNumberOfChildren());
        double newTotalAmount = updatedRequest.getNumberOfAdults() * tour.getAdultPrice()
                + updatedRequest.getNumberOfChildren() * tour.getChildPrice();
        existingPurchase.setTotalAmount(newTotalAmount);
        existingPurchase.setPurchaseDate(LocalDateTime.now());
        return purchasedTourRepository.save(existingPurchase);
    }
    public List<PurchasedTour> findUsersPurchasedTours() {
        AppUser user = userService.getLoggedUser();
        return purchasedTourRepository.findByAppUserOrderByPurchaseDateDesc(user);
    }
    public List<PurchasedTour> findToursPurchasing(Long tourId) {
        return purchasedTourRepository.findByTour_Id(tourId);
    }

    public List<PurchasedTour> findLatest() {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        return purchasedTourRepository.findAllByPurchaseDateAfter(yesterday);
    }
}


