package com.protik.travel_agency.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityRequest {
    private String name;
    private Long countryId;
}
