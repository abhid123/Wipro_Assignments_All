package com.example.hotel_booking_system_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hotel_booking_system_rest_api.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
