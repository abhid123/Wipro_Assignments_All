package com.example.movie_ticket_booking_app_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.movie_ticket_booking_app_rest_api.model.Customer;
import com.example.movie_ticket_booking_app_rest_api.model.Movie;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, Long>{

}
