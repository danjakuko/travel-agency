package com.protik.travel_agency.models;

import lombok.Getter;

@Getter
public class TourSearch {
    private String tourName;
    private Long fromAirport;
    private Long toAirport;
    private Long fromCity;
    private Long toCity;
    private Long toHotel;
    private Integer numberOfDays;
    private String tourType;
    private String tourStatus;
    private String continent;
    private Long country;
    private Integer numberOfSeats;

}
