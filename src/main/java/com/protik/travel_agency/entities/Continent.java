package com.protik.travel_agency.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "continents")
@Data
public class Continent {

    @Id
    private String name;

}
