package com.protik.travel_agency.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "purchased_tours")
@Data
public class PurchasedTour extends GenericEntity {
    @ManyToOne
    private Tour tour;
    private Integer adults;
    private Integer children;
    private Double amount;
    @ManyToOne
    private AppUser appUser;
}
