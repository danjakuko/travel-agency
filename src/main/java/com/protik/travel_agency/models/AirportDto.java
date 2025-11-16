package com.protik.travel_agency.models;

import com.protik.travel_agency.static_data.AirportStatus;
import lombok.Data;

@Data
public class AirportDto {
    private String airportName;
    private Long cityId;
    private AirportStatus status;
}
