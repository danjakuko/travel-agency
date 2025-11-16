package com.protik.travel_agency.controllers;

import com.protik.travel_agency.entities.Hotel;
import com.protik.travel_agency.models.HotelDto;
import com.protik.travel_agency.services.HotelService;
import com.protik.travel_agency.static_data.HotelStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/all")
    public List<Hotel> getAllHotels() {
        return hotelService.findAll();
    }

    @GetMapping("{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelService.findById(id);
    }

    @PostMapping("/create")
    public Hotel createHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.create(hotelDto);
    }

    @PutMapping("/update/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody HotelDto hotelDto) {
        return hotelService.update(id, hotelDto);
    }

    @GetMapping("/by_name")
    public List<Hotel> findHotelByName(@RequestParam String name) {
        return hotelService.findByName(name);
    }

    @GetMapping("/by_city")
    public List<Hotel> findHotelByCity(@RequestParam Long cityId) {
        return hotelService.findByCity(cityId);
    }

    @GetMapping("/by_standard")
    public List<Hotel> findHotelByStandard(@RequestParam String standard) {
        return hotelService.findByStandard(HotelStandard.valueOf(standard));
    }
}
