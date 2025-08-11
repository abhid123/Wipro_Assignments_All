package com.example.movie_ticket_booking_app_rest_api.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Booking 
{ 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	private LocalDate bookingDate; 
	private int seats; 

	//@ManyToOne 
//@JoinColumn(name = "movie_id") 
//private Movie movie; 
//@ManyToOne 
//@JoinColumn(name = "theater_id") 
//private Theater theater; 
//@ManyToOne 
//@JoinColumn(name = "customer_id") 
//private Customer customer; 
// Getters and Setters 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingDate=" + bookingDate + ", seats=" + seats + "]";
	}
}