package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.Continent;
import com.protik.travel_agency.entities.Country;
import com.protik.travel_agency.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ContinentService continentService;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(()-> new RuntimeException("Country does not exist."));
    }

    public Country create(String name, String continentId) {
        if (countryRepository.existsByName(name)){
            throw new RuntimeException("Country already exists");
        }
        Continent continent = continentService.findById(continentId);
        Country country = new Country();
        country.setContinent(continent);
        country.setName(name);
        return countryRepository.save(country);
    }



}
