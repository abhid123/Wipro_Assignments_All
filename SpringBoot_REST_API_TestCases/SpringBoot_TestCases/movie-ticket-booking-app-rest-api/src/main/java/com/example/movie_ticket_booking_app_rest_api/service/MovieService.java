package com.example.movie_ticket_booking_app_rest_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_ticket_booking_app_rest_api.model.Movie;
import com.example.movie_ticket_booking_app_rest_api.model.Theater;
import com.example.movie_ticket_booking_app_rest_api.repository.MovieRepository;
import com.example.movie_ticket_booking_app_rest_api.repository.TheaterRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	private TheaterRepository theaterRepository;  


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
	
	public Movie addTheatersToMovie(Long movieId, List<Long> theaterIds) {
		Movie movie = getMovieById(movieId);
		List<Theater> theaters = theaterRepository.findAllById(theaterIds);
		movie.setTheaters(theaters);
		return movieRepository.save(movie);
	}
	

}
