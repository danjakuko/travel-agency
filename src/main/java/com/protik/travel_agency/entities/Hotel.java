package com.protik.travel_agency.entities;

import com.protik.travel_agency.static_data.HotelStandard;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hotels")
@Data
public class Hotel extends GenericEntity {
    private String name;
    private String description;
    public String address;
    @Enumerated(value = EnumType.STRING)
    private HotelStandard standard;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
