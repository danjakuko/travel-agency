package com.protik.travel_agency.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "airports")
@Data
public class Airport extends GenericEntity{
}
