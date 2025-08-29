package com.example.booking_service.controller;

import org.springframework.web.bind.annotation.*;

import com.example.booking_service.model.Booking;
import com.example.booking_service.model.BookingStatus;
import com.example.booking_service.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @PutMapping("/{id}/status")
    public Booking updateBookingStatus(@PathVariable Long id, @RequestParam BookingStatus status) {
        return bookingService.updateBookingStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}
