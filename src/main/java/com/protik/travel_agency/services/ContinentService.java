package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.Continent;
import com.protik.travel_agency.repositories.ContinentRepository;
import com.protik.travel_agency.static_data.ContinentName;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentService {
    @Autowired
    private ContinentRepository continentRepository;

    public List<Continent> findAll() {
        return continentRepository.findAll();
    }

    public Continent findById(String id) {
        return continentRepository.findById(id).orElseThrow(() -> new RuntimeException("Continent does not exist."));
    }

    @PostConstruct
    public void init() {
        for (ContinentName name : ContinentName.values()) {
            if (!continentRepository.existsById(name.name())) {
                Continent continent = new Continent();
                continent.setName(name.name());
                continentRepository.save(continent);
            }
        }
    }
}
