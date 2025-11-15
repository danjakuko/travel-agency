package com.protik.travel_agency.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "airports")
@Data
public class Airport extends GenericEntity{
    private String name;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
