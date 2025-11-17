package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.Tour;
import com.protik.travel_agency.models.TourDto;
import com.protik.travel_agency.repositories.TourRepository;
import com.protik.travel_agency.static_data.TourStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service

public class TourService {
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private AirportService airportService;
    @Autowired
    private CityService cityService;
    @Autowired
    private HotelService hotelService;

    public Tour findById(Long id) {
        return tourRepository.findById(id).orElseThrow(() -> new RuntimeException("Tour not found"));
    }

    public Tour create(TourDto tourDto) {
        Tour tour = new Tour();
        tour.setTourStatus(TourStatus.IN_PROGRESS);
        return save(tourDto, tour);
    }

    private Tour save(TourDto tourDto, Tour tour) {
        tour.setAdultPrice(tourDto.getAdultPrice());
        tour.setChildPrice(tourDto.getChildPrice());
        tour.setName(tourDto.getTourName());
        tour.setDescription(tour.getDescription());
        tour.setDepartureDate(tourDto.getDepartureDate());
        tour.setArrivalDate(tourDto.getArrivalDate());
        tour.setNumberOfSeats(tourDto.getAvailableSeats());
        Long daysBetween = ChronoUnit.DAYS.between(tourDto.getDepartureDate(), tourDto.getArrivalDate());
        tour.setNumberOfDays(daysBetween.intValue());
        tour.setFromAirport(airportService.findById(tourDto.getFromAirportId()));
        tour.setToAirport(airportService.findById(tourDto.getToAirportId()));
        tour.setFromCity(cityService.findById(tourDto.getFromCityId()));
        tour.setToCity(cityService.findById(tourDto.getToCityId()));
        tour.setToHotel(hotelService.findById(tourDto.getHotelId()));
        return tourRepository.save(tour);
    }

    public Tour update(TourDto tourDto, Long id) {
        Tour tour = findById(id);
        tour.setTourStatus(tourDto.getStatus());
        return save(tourDto, tour);
    }

    public Tour cancel (TourDto tourDto) {
        return null;
    }
}
