package com.example.movie_ticket_booking_app_rest_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_ticket_booking_app_rest_api.model.Movie;
import com.example.movie_ticket_booking_app_rest_api.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;

	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie m = movieRepository.save(movie);
		return m;
		
	}

	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

	public Movie getMovieById(Long id) {
		// TODO Auto-generated method stub
		return movieRepository.findById(id).get();
	}

	public void deleteMovie(Long id) {
		// TODO Auto-generated method stub
		
		movieRepository.deleteById(id);
		
	}
	
	

}
