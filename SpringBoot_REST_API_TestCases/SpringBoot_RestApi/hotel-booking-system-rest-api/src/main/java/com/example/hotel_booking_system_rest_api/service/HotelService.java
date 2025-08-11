package com.example.hotel_booking_system_rest_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.hotel_booking_system_rest_api.model.Hotel;
import com.example.hotel_booking_system_rest_api.repository.HotelRepository;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long id, Hotel hotel) {
        return hotelRepository.findById(id).map(existing -> {
            existing.setName(hotel.getName());
            existing.setLocation(hotel.getLocation());
            existing.setRooms(hotel.getRooms());
            return hotelRepository.save(existing);
        }).orElse(null);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
