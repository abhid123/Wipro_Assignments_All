package com.example.hotel_booking_system_rest_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.hotel_booking_system_rest_api.model.Room;
import com.example.hotel_booking_system_rest_api.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRoomsForHotel(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room room) {
        return roomRepository.findById(id).map(existing -> {
            existing.setRoomNumber(room.getRoomNumber());
            existing.setType(room.getType());
            existing.setPrice(room.getPrice());
            existing.setHotel(room.getHotel());
            return roomRepository.save(existing);
        }).orElse(null);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
