package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.Hotel;
import com.protik.travel_agency.static_data.HotelStandard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByStandard(HotelStandard standard);
    List<Hotel> findByName(String name);
    List<Hotel> findByCity_Id(Long city);
}
