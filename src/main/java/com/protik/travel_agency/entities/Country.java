package com.protik.travel_agency.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "countries")
@Data
public class Country extends GenericEntity {
    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continent;

}
