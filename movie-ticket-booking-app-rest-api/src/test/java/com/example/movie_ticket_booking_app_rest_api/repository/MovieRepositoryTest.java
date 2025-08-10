package com.example.movie_ticket_booking_app_rest_api.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.movie_ticket_booking_app_rest_api.model.Movie;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void testSaveMovie() {
        // Arrange
        Movie movie = new Movie();
        movie.setTitle("Interstellar");
        movie.setGenre("Sci-Fi");

        // Act
        Movie result = movieRepository.save(movie);

        // Assert
        assertNotNull(result.getId());
        assertEquals("Interstellar", result.getTitle());
        assertEquals("Sci-Fi", result.getGenre());
    }

    @Test
    void testFindById() {
        // Arrange
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setGenre("Thriller");
        Movie saved = movieRepository.save(movie);

        // Act
        Optional<Movie> result = movieRepository.findById(saved.getId());

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Inception", result.get().getTitle());
    }

//    @Test
//    void testFindByTitle() {
//        // Arrange
//        Movie movie = new Movie();
//        movie.setTitle("The Dark Knight");
//        movie.setGenre("Action");
//        movieRepository.save(movie);
//
//        // Act
//        Optional<Movie> result = movieRepository.findByTitle("The Dark Knight");
//
//        // Assert
//        assertTrue(result.isPresent());
//        assertEquals("The Dark Knight", result.get().getTitle());
//    }
}
