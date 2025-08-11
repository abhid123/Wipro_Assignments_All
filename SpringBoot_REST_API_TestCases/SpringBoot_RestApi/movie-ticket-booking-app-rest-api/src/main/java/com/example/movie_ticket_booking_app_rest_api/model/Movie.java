package com.example.movie_ticket_booking_app_rest_api.model;

//import javax.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;

//import java.util.List; 
@Entity 
public class Movie 
{ 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	private String title; 
	private String genre;
	
	//@ManyToMany 
	//@JoinTable( 
	//name = "movie_theater",  
	//joinColumns = @JoinColumn(name = "movie_id"),  
	//inverseJoinColumns = @JoinColumn(name = "theater_id")) 
	//private List<Theater> theaters; 
	// Getters and Setters 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + "]";
	} 
	
	

} 