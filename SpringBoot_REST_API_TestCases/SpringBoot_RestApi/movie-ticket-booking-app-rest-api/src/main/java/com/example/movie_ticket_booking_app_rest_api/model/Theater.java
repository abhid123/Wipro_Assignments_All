package com.example.movie_ticket_booking_app_rest_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//import javax.persistence.*; 
//import java.util.List; 

@Entity 
public class Theater 
{ 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	private String name; 
	private String location;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + ", location=" + location + "]";
	} 
	
	
//@ManyToMany(mappedBy = "theaters") 
//private List<Movie> movies; 
// Getters and Setters 
	
	
}