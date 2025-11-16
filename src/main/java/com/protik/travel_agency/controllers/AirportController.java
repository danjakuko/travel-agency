package com.protik.travel_agency.controllers;

import com.protik.travel_agency.entities.Airport;
import com.protik.travel_agency.models.AirportDto;
import com.protik.travel_agency.services.AirportService;
import com.protik.travel_agency.static_data.AirportStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping("/all")
    public List<Airport> getAll() {
        return airportService.findAll();
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable Long id) {
        return airportService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Airport update(@PathVariable Long id, @RequestBody AirportDto airportDto) {
        return airportService.update(id,airportDto);
    }

    @PostMapping("/create")
    public Airport create(@RequestBody AirportDto airportDto) {
        return airportService.create(airportDto);
    }

    @GetMapping("/by_city")
    public List<Airport> findByCity(@RequestParam Long cityId) {
        return airportService.findByCityId(cityId);
    }

    @GetMapping("/by_status")
    public List<Airport> findByStatus(@RequestParam String status) {
        return airportService.findByStatus(AirportStatus.valueOf(status));
    }
}
