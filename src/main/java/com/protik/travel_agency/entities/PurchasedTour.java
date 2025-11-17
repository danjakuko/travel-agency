package com.protik.travel_agency.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchased_tours")
@Data
public class PurchasedTour extends GenericEntity {
    @ManyToOne
    private Tour tour;
    private Integer adults;
    private Integer children;
    private Double totalAmount;
    private LocalDateTime purchaseDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;
}
