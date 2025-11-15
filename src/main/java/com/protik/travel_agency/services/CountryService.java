package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.Continent;
import com.protik.travel_agency.entities.Country;
import com.protik.travel_agency.models.CountryRequest;
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
        return countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country does not exist."));
    }

    public Country create(CountryRequest countryRequest) {
        Country country = new Country();
        return save(countryRequest, country);
    }

    private Country save(CountryRequest countryRequest, Country country) {
        Continent continent = continentService.findById(countryRequest.getContinentId());
        country.setContinent(continent);
        country.setName(countryRequest.getName());
        return countryRepository.save(country);
    }

    public Country update(CountryRequest countryRequest, Long id) {
        Country country = findById(id);
        return save(countryRequest, country);
    }

    public List<Country> findByName(String name) {
        return countryRepository.findAllByNameContainsIgnoreCase(name);
   }

    public List<Country> findByContinent(String continentId) {
        return countryRepository.findByContinent_Name(continentId);
    }


}

