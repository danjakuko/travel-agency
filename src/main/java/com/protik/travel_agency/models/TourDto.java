package com.protik.travel_agency.models;

import com.protik.travel_agency.static_data.TourStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TourDto {
    private String tourName;
    private String tourDescription;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Integer availableSeats;
    private Double adultPrice;
    private Double childPrice;
    private TourStatus status;
    private Long hotelId;
    private Long fromCityId;
    private Long toCityId;
    private Long fromAirportId;
    private Long toAirportId;
}
