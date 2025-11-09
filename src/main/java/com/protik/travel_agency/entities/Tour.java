package com.protik.travel_agency.entities;

import com.protik.travel_agency.static_data.TourType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tours")
@Data
public class Tour extends GenericEntity {
    @ManyToOne
    private City fromCity;
    @ManyToOne
    private Airport fromAirport;
    @ManyToOne
    private City toCity;
    @ManyToOne
    private Airport toAirport;
    @ManyToOne
    private Hotel toHotel;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Integer numberOfDays;
    @Enumerated(value = EnumType.STRING)
    private TourType tourType;
    private Double adultPrice;
    private Double childPrice;
    private boolean promoted;
    private Integer numberOfSeats;

}
