package com.example.movie_ticket_booking_app_rest_api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.movie_ticket_booking_app_rest_api.model.Theater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.movie_ticket_booking_app_rest_api.model.Movie;
import com.example.movie_ticket_booking_app_rest_api.repository.MovieRepository;
import com.example.movie_ticket_booking_app_rest_api.repository.TheaterRepository;

@SpringBootTest
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private TheaterRepository theaterRepository;

    @InjectMocks
    private MovieService movieService;

    private Movie movie;

    @BeforeEach
    public void setUp() {
        movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Inception");
        movie.setGenre("Sci-Fi");
    }

    @Test
    void testSaveMovie() {
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);

        Movie savedMovie = movieService.saveMovie(movie);
        assertNotNull(savedMovie);
        assertEquals("Inception", savedMovie.getTitle());
        assertEquals("Sci-Fi", savedMovie.getGenre());
    }

    @Test
    void testGetAllMovies() {
        List<Movie> movieList = Arrays.asList(movie);
        when(movieRepository.findAll()).thenReturn(movieList);

        List<Movie> result = movieService.getAllMovies();
        assertEquals(1, result.size());
        assertEquals("Inception", result.get(0).getTitle());
    }

    @Test
    void testGetMovieById() {
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));

        Movie result = movieService.getMovieById(1L);
        assertNotNull(result);
        assertEquals("Inception", result.getTitle());
    }

    @Test
    void testDeleteMovie() {
        doNothing().when(movieRepository).deleteById(1L);

        movieService.deleteMovie(1L);

        verify(movieRepository, times(1)).deleteById(1L);
    }

    @Test
    void testAddTheatersToMovie() {
        Theater theater1 = new Theater();
        theater1.setId(100L);
        theater1.setName("IMAX");

        List<Theater> theaters = Arrays.asList(theater1);
        List<Long> theaterIds = Arrays.asList(100L);

        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));
        when(theaterRepository.findAllById(theaterIds)).thenReturn(theaters);
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);

        Movie updatedMovie = movieService.addTheatersToMovie(1L, theaterIds);
        assertNotNull(updatedMovie);
        verify(movieRepository).save(movie);
    }
}
