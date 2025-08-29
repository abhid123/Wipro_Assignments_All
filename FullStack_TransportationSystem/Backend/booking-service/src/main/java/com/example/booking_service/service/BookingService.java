package com.example.booking_service.service;

import org.springframework.stereotype.Service;

import com.example.booking_service.Feign.DriverClient;
import com.example.booking_service.Feign.RouteClient;
import com.example.booking_service.Feign.VehicleClient;
import com.example.booking_service.dto.DriverDTO;
import com.example.booking_service.dto.RouteDTO;
import com.example.booking_service.dto.VehicleDTO;
import com.example.booking_service.model.Booking;
import com.example.booking_service.model.BookingStatus;
import com.example.booking_service.repository.BookingRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final VehicleClient vehicleClient;
    private final RouteClient routeClient;
    private final DriverClient driverClient;

    public BookingService(BookingRepository bookingRepository, VehicleClient vehicleClient,
                          RouteClient routeClient, DriverClient driverClient) {
        this.bookingRepository = bookingRepository;
        this.vehicleClient = vehicleClient;
        this.routeClient = routeClient;
        this.driverClient = driverClient;
    }

    public Booking createBooking(Booking booking) {
        // Validate from other services
        VehicleDTO vehicle = vehicleClient.getVehicleById(booking.getVehicleId());
        RouteDTO route = routeClient.getRouteById(booking.getRouteId());
        DriverDTO driver = driverClient.getDriverById(booking.getDriverId());

        if (vehicle == null || route == null || driver == null) {
            throw new RuntimeException("Invalid vehicle, route, or driver");
        }

        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setBookingTime(new Timestamp(System.currentTimeMillis()));
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking updateBookingStatus(Long id, BookingStatus status) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setBookingStatus(status);
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
