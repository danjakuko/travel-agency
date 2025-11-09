package com.protik.travel_agency.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "hotels")
@Data
public class Hotel extends GenericEntity {

}
