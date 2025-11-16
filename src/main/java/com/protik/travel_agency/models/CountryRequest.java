package com.protik.travel_agency.models;

import com.protik.travel_agency.entities.Country;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryRequest {
    @NotNull
    private String name;
    @NotNull
    private String continentId;
}
