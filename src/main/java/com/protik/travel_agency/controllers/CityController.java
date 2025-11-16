package com.protik.travel_agency.controllers;

import com.protik.travel_agency.entities.City;
import com.protik.travel_agency.entities.Country;
import com.protik.travel_agency.models.CityRequest;
import com.protik.travel_agency.models.CountryRequest;
import com.protik.travel_agency.services.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/all")
    public List<City> getAll() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public City getCityByName(@PathVariable Long id) {
        return cityService.findById(id);
    }


    @PutMapping("/update/{id}")
    public City update(@PathVariable Long id,@Valid @RequestBody CityRequest cityRequest) {
        return cityService.update(cityRequest, id);
    }

    @GetMapping("/find/{name}")
    public List<City> findByName(@PathVariable String name) {
        return cityService.findByName(name);
    }

    @GetMapping("/country/{countryId}")
    public List<City> findByCountry(@PathVariable Long countryId) {
        return cityService.findByCountry(countryId);
    }

}
