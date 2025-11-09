package com.protik.travel_agency.entities;

import com.protik.travel_agency.static_data.HotelStandard;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "hotels")
@Data
public class Hotel extends GenericEntity {
    private String name;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private HotelStandard standard;
}
