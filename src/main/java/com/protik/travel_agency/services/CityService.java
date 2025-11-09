package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.City;
import com.protik.travel_agency.entities.Country;
import com.protik.travel_agency.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryService countryService;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(()-> new RuntimeException("City does not exist."));
    }

    public City create(String name, Long countryId) {
        Country country = countryService.findById(countryId);
        City city = new City();
        city.setCountry(country);
        city.setName(name);
        return cityRepository.save(city);
    }
}
