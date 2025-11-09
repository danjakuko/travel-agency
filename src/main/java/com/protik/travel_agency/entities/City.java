package com.protik.travel_agency.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cities")
@Data
public class City extends GenericEntity {
private String name;

@ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
