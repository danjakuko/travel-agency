package com.protik.travel_agency.models;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityRequest {
    @NotNull
    private String name;
    @NotNull
    private Long countryId;
}
