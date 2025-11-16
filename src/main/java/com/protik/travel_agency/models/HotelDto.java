package com.protik.travel_agency.models;

import com.protik.travel_agency.static_data.HotelStandard;
import lombok.Data;

@Data
public class HotelDto {
    private Long hotelId;
    private String hotelName;
    private String hotelAddress;
    private Long cityId;
    private HotelStandard standard;
}
