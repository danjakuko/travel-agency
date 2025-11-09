package com.protik.travel_agency.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchasedTourRequest {
    private Long tourId;
    private Integer numberOfAdults;
    private Integer numberOfChildren;
    private Double totalPrice;
}
