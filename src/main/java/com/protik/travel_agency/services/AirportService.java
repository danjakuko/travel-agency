package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.Airport;
import com.protik.travel_agency.models.AirportRequest;
import com.protik.travel_agency.repositories.AirportRepository;
import com.protik.travel_agency.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CityRepository cityRepository;


    public Airport findById(Long id){
        return airportRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Airport with id "+id+" not found"));
    }

    public List<Airport> findAll(){
        return airportRepository.findAll();
    }


    public Airport update(Airport airport){
        if(airport.getId() != null && airportRepository.existsById(airport.getId())){
            return airportRepository.save(airport);
        }else if(airportRepository.existsById(airport.getId())){
            throw new RuntimeException("Airport with id "+airport.getId()+" not found");
        }else{
            throw new RuntimeException("Airport with id "+airport.getId()+" is out of service");
        }
    }

    public Airport create(AirportRequest airportRequest){
        Airport airport = new Airport();
        airport.setName(airportRequest.getName());
        airport.setId(airportRequest.getCityId());
        return airportRepository.save(airport);
    }

    public List<Airport> findByCityName(String cityName){
        return airportRepository.findByCityName(cityName);
    }

}
