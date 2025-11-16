package com.protik.travel_agency.controllers;

import com.protik.travel_agency.entities.Continent;
import com.protik.travel_agency.entities.Country;
import com.protik.travel_agency.models.CountryRequest;
import com.protik.travel_agency.services.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/all")
    public List<Country> getAll() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable Long id) {
        return countryService.findById(id);
    }

    @PostMapping("/create")
    public Country create(@Valid @RequestBody CountryRequest countryRequest) {
        return countryService.create(countryRequest);
    }

    @PutMapping("/update/{id}")
    public Country update(@PathVariable Long id,@Valid @RequestBody CountryRequest countryRequest) {
        return countryService.update(countryRequest, id);
    }

    @GetMapping("/find/{name}")
    public List<Country> findByName(@PathVariable String name) {
        return countryService.findByName(name);
    }

    @GetMapping("/continent/{continentId}")
    public List<Country> findByContinent(@PathVariable String continentId) {
        return countryService.findByContinent(continentId);
    }

}
