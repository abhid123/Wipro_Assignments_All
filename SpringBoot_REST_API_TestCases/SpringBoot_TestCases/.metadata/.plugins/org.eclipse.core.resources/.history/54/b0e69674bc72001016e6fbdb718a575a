package com.example.movie_ticket_booking_app_rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.movie_ticket_booking_app_rest_api.model.Customer;
import com.example.movie_ticket_booking_app_rest_api.model.Movie;
//import com.example.movie_ticket_booking_app_rest_api.service.CustomerService;
import com.example.movie_ticket_booking_app_rest_api.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}

	@PostMapping("/movies")
	public Movie createMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
		Movie movie = movieService.getMovieById(id);
		return  new ResponseEntity<Movie>(movie,HttpStatus.OK) ;
	}
	
	@PutMapping("/movies/{id}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable Long id) {
		Movie existingMovie = movieService.getMovieById(id);
    	existingMovie.setTitle(movie.getTitle());
//    	existingCustomer.setPassword(customer.getPassword());
    	existingMovie.setGenre(movie.getGenre());
    	
    	Movie result = movieService.saveMovie(existingMovie);
    	
    	return result;		
		
	}
	@DeleteMapping("/movies/{id}")
	public String deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return "Movie deleted with this "+id;
		
	}
	
	@PostMapping("/movies/{movieId}/theaters")
	public ResponseEntity<Movie> addTheatersToMovie(@PathVariable Long movieId, @RequestBody List<Long> theaterIds) {
	    Movie updatedMovie = movieService.addTheatersToMovie(movieId, theaterIds);
	    return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
	}

}