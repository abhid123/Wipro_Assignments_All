package com.example.movie_ticket_booking_app_rest_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_ticket_booking_app_rest_api.model.Theater;
import com.example.movie_ticket_booking_app_rest_api.repository.TheaterRepository;

@Service
public class TheaterService {
    
    @Autowired
    private TheaterRepository theaterRepository;

    public Theater saveTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id).get();
    }

    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
