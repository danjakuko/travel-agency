package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.*;
import com.protik.travel_agency.models.TourDto;
import com.protik.travel_agency.models.TourSearch;
import com.protik.travel_agency.repositories.TourRepository;
import com.protik.travel_agency.static_data.TourStatus;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.

        springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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

    public Tour cancel(Long id) {
        Tour tour = findById(id);
        tour.setTourStatus(TourStatus.CANCELLED);
        return tourRepository.save(tour);
    }

    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    public List<Tour> findByFromAirport(Long fromAirportId) {
        return tourRepository.findAllByFromAirport_Id(fromAirportId);
    }

    public List<Tour> findByToAirport(Long toAirportId) {
        return tourRepository.findAllByToAirport_Id(toAirportId);
    }

    public List<Tour> findByFromCity(Long fromCityId) {
        return tourRepository.findAllByFromCity_Id(fromCityId);
    }

    public List<Tour> findByToCity(Long toCityId) {
        return tourRepository.findAllByToCity_Id(toCityId);
    }

    public List<Tour> findAllToHotel(Long fromHotelId) {
        return tourRepository.findAllByToHotel_Id(fromHotelId);
    }

    public List<Tour> findByName(String name) {
        return tourRepository.findAllByNameContainsIgnoreCase(name);
    }

    public List<Tour> search(TourSearch tourSearch) {
        Specification<Tour> specification = createSpecification(tourSearch);
        return tourRepository.findAll(specification);
    }

    private Specification<Tour> createSpecification(TourSearch tourSearch) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            Join<Tour, City> cityRoot = root.join("toCity");
            Join<City, Country> countryJoin = cityRoot.join("country");
            Join<Country, Continent> continentRoot = countryJoin.join("continent");
            if (tourSearch.getTourStatus() != null) {
                predicates.add(cb.equal(root.get("tourStatus"), tourSearch.getTourStatus()));
            }
            if (tourSearch.getFromAirport() != null) {
                predicates.add(cb.equal(root.get("fromAirport").get("id"), tourSearch.getFromAirport()));
            }
            if (tourSearch.getToAirport() != null) {
                predicates.add(cb.equal(root.get("toAirport").get("id"), tourSearch.getToAirport()));
            }
            if (tourSearch.getFromCity() != null) {
                predicates.add(cb.equal(root.get("fromCity").get("id"), tourSearch.getFromCity()));
            }
            if (tourSearch.getToCity() != null) {
                predicates.add(cb.equal(root.get("toCity").get("id"), tourSearch.getToCity()));
            }
            if (tourSearch.getToHotel() != null) {
                predicates.add(cb.equal(root.get("toHotel").get("id"), tourSearch.getToHotel()));
            }
            if (tourSearch.getTourName() != null) {
                predicates.add(cb.like(root.get("tourName"), "%" + tourSearch.getTourName() + "%"));
            }
            if (tourSearch.getContinent() != null) {
                predicates.add(cb.equal(continentRoot.get("name"), tourSearch.getContinent()));
            }
            if (tourSearch.getCountry() != null) {
                predicates.add(cb.equal(countryJoin.get("id"), tourSearch.getCountry()));
            }
            if (tourSearch.getNumberOfSeats() != null) {
                predicates.add(cb.equal(root.get("numberOfSeats"), tourSearch.getNumberOfSeats()));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
