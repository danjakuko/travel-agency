package com.protik.travel_agency.controllers;

import com.protik.travel_agency.entities.PurchasedTour;
import com.protik.travel_agency.models.PurchasedTourRequest;
import com.protik.travel_agency.services.PurchasedTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchased_tour")
public class PurchasedTourController {
    @Autowired
    private PurchasedTourService purchasedTourService;
    @GetMapping("/create")
    public PurchasedTour create(@RequestBody PurchasedTourRequest purchasedTourRequest) {
        return purchasedTourService.create(purchasedTourRequest);
    }
    @GetMapping("/by_id")
    public PurchasedTour getById(@RequestParam Long id) {
        return purchasedTourService.findById(id);
    }
    @GetMapping("/all")
    public List<PurchasedTour> getAll() {
        return purchasedTourService.findAll();
    }
    @PutMapping("/update/{id}")
    public PurchasedTour update(@PathVariable Long id, @RequestBody PurchasedTourRequest purchasedTourRequest) {
        return purchasedTourService.update(id, purchasedTourRequest);
    }
    @GetMapping("/by_user")
    public List<PurchasedTour> getByUser() {
        return purchasedTourService.findUsersPurchasedTours();
    }
    @GetMapping("/by_tour")
    public List<PurchasedTour> getByTour(@RequestParam Long tourId) {
        return purchasedTourService.findToursPurchasing(tourId);
    }
    @GetMapping("/latest")
    public List<PurchasedTour> getLatest() {
        return purchasedTourService.findLatest();
    }
}
