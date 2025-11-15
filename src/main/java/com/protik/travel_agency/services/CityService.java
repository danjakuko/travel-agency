package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.City;
import com.protik.travel_agency.entities.Continent;
import com.protik.travel_agency.entities.Country;
import com.protik.travel_agency.models.CityRequest;
import com.protik.travel_agency.models.CountryRequest;
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
        return cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City does not exist."));
    }

    public City create(CityRequest request) {
        City city = new City();
        return save(request, city);
    }

    private City save(CityRequest cityRequest, City city) {
        Country country  = countryService.findById(cityRequest.getCountryId());
        city.setCountry(country);
        city.setName(cityRequest.getName());
        return cityRepository.save(city);
    }

    public City update(CityRequest cityRequest, Long id) {
        City city = findById(id);
        return save(cityRequest, city);
    }

    public List<City> findByName(String name) {
        return cityRepository.findAllByNameContainsIgnoreCase(name);
    }

    public List<City> findByCountry(Long countryId) {
        return cityRepository.findAllByCountry_Id(countryId);
    }


}
