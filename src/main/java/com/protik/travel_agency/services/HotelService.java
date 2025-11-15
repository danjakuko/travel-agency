package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.Hotel;
import com.protik.travel_agency.repositories.HotelRepository;
import com.protik.travel_agency.static_data.HotelStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Hotel findById(Long id){
        return hotelRepository.findById(id).orElseThrow(()->new RuntimeException("Hotel not found"));
    }

    public List<Hotel> findAll(){
        return hotelRepository.findAll();
    }

    public List<Hotel> findByCity(Long cityId){
        return hotelRepository.findByCity_Id(cityId);
    }

    public List<Hotel> findByName(String name){
        return hotelRepository.findByName(name);
    }

    public List<Hotel> findByStandard(HotelStandard standard){
        return hotelRepository.findByStandard(standard);
    }

}
