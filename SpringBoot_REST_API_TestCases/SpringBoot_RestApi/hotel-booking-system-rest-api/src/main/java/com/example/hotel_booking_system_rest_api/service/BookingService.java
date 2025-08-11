package com.example.hotel_booking_system_rest_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.hotel_booking_system_rest_api.model.Booking;
import com.example.hotel_booking_system_rest_api.repository.BookingRepository;
import com.example.hotel_booking_system_rest_api.repository.RoomRepository;
import com.example.hotel_booking_system_rest_api.repository.CustomerRepository;
import com.example.hotel_booking_system_rest_api.model.Room;
import com.example.hotel_booking_system_rest_api.model.Customer;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;

    public BookingService(BookingRepository bookingRepository,
                          RoomRepository roomRepository,
                          CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.customerRepository = customerRepository;
    }

    public Booking createBooking(Booking booking) {
        // Basic validation — ensure room & customer exist
        if (booking.getRoom() != null && booking.getCustomer() != null) {
            Room r = roomRepository.findById(booking.getRoom().getId()).orElse(null);
            Customer c = customerRepository.findById(booking.getCustomer().getId()).orElse(null);
            if (r == null || c == null) {
                throw new RuntimeException("Room or Customer not found");
            }
            booking.setRoom(r);
            booking.setCustomer(c);
            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("Room and Customer must be provided");
        }
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getBookingsByCustomerId(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    public Booking updateBooking(Long id, Booking booking) {
        return bookingRepository.findById(id).map(existing -> {
            existing.setCheckInDate(booking.getCheckInDate());
            existing.setCheckOutDate(booking.getCheckOutDate());
            if (booking.getRoom() != null) {
                roomRepository.findById(booking.getRoom().getId()).ifPresent(existing::setRoom);
            }
            if (booking.getCustomer() != null) {
                customerRepository.findById(booking.getCustomer().getId()).ifPresent(existing::setCustomer);
            }
            return bookingRepository.save(existing);
        }).orElse(null);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
