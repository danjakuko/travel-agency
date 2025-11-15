package com.protik.travel_agency.entities;

import com.protik.travel_agency.static_data.AirportStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "airports")
@Data
public class Airport extends GenericEntity{
    private String name;
    @Enumerated(EnumType.STRING)
    private AirportStatus airportStatus;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
