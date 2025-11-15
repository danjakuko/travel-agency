package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.Airport;
import com.protik.travel_agency.models.AirportDto;
import com.protik.travel_agency.repositories.AirportRepository;
import com.protik.travel_agency.repositories.CityRepository;
import com.protik.travel_agency.static_data.AirportStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CityService cityService;

    public Airport findById(Long id){
        return airportRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Airport with id "+id+" not found"));
    }

    public List<Airport> findAll(){
        return airportRepository.findAll();
    }

    public Airport update(Long id, AirportDto airportDto) {
        if (airportDto.getAirportName() == null || airportDto.getAirportName().trim().isEmpty()) {
            throw new RuntimeException("Invalid new name.");
        }
        Airport airport = findById(id);
        airport.setName(airportDto.getAirportName());
        if (airportDto.getStatus() != null) {
            airport.setAirportStatus(airportDto.getStatus());
        }
        return airportRepository.save(airport);
    }

    public Airport create(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setName(airportDto.getAirportName());
        airport.setCity(cityService.findById(airportDto.getCityId()));
        airport.setAirportStatus(airportDto.getStatus());
        return airportRepository.save(airport);
    }

    public List<Airport> findByCityId(Long cityId){
        return airportRepository.findByCityId(cityId);
    }

    public List<Airport> findByStatus(AirportStatus status){
        return airportRepository.findByAirportStatus(status);
    }
}
