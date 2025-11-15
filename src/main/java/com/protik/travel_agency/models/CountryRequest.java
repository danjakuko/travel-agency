package com.protik.travel_agency.models;

import com.protik.travel_agency.entities.Country;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryRequest {
    private String name;
    private String continentId;
}
