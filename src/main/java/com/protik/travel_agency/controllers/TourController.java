package com.protik.travel_agency.controllers;

import com.protik.travel_agency.entities.Tour;
import com.protik.travel_agency.models.TourDto;
import com.protik.travel_agency.models.TourSearch;
import com.protik.travel_agency.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour")
public class TourController {
    @Autowired
    private TourService tourService;

    @GetMapping("/all")
    public List<Tour> getAll() {
        return tourService.findAll();
    }

    @GetMapping("/find")
    public Tour findById(Long id) {
        return tourService.findById(id);
    }

    @GetMapping("/from_airport")
    public List<Tour> getFromAirport(@RequestParam Long airportId) {
        return tourService.findByFromAirport(airportId);
    }

    @GetMapping("/to_airport")
    public List<Tour> getToAirport(@RequestParam Long airportId) {
        return tourService.findByToAirport(airportId);
    }

    @GetMapping("/from_city")
    public List<Tour> getFromCity(@RequestParam Long cityId) {
        return tourService.findByFromCity(cityId);
    }

    @GetMapping("/to_city")
    public List<Tour> getToCity(@RequestParam Long cityId) {
        return tourService.findByToCity(cityId);
    }

    @GetMapping("/to_hotel")
    public List<Tour> getToHotel(@RequestParam Long hotelId) {
        return tourService.findAllToHotel(hotelId);
    }

    @GetMapping("/by_name")
    public List<Tour> getByName(@RequestParam String name) {
        return tourService.findByName(name);
    }

    @PostMapping("/create")
    public Tour create(@RequestBody TourDto tourDto) {
        return tourService.create(tourDto);
    }

    @PutMapping("/update/{id}")
    public Tour update(@PathVariable Long id, @RequestBody TourDto tourDto) {
        return tourService.update(tourDto, id);
    }

    @PostMapping("/filter")
    public List<Tour> filter(@RequestBody TourSearch tourSearch) {
        return tourService.search(tourSearch);
    }
}
