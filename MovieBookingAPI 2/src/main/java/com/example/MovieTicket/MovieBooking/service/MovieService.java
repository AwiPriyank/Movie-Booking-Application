package com.example.MovieTicket.MovieBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExistException;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFoundException;
import com.example.MovieTicket.MovieBooking.Model.Movie;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MovieService implements MovieServiceInterface {

    private final Map<String, Movie> movies = new ConcurrentHashMap<>();

    @Autowired
    private Validator validator;

    @Override
    public List<Movie> findAllMovies() {
        return new ArrayList<>(movies.values());
    }

    @Override
    public Movie addMovie(Movie movie) {
        // Validate the movie object
        Errors errors = new BeanPropertyBindingResult(movie, "movie");
        validator.validate(movie, errors);

        if (errors.hasErrors()) {
            throw new RuntimeException("Validation errors: " + errors.getAllErrors());
        }

        if (movies.containsKey(movie.getId())) {
            throw new IdAlreadyExistException("A movie with ID " + movie.getId() + " already exists.");
        }
        movies.put(movie.getId(), movie);
        return movie;
    }

    @Override
    public Optional<Movie> findMovieById(String id) {
        return Optional.ofNullable(movies.get(id));
    }

    @Override
    public void deleteMovieById(String id) {
        if (!movies.containsKey(id)) {
            throw new IdNotFoundException("No movie found with ID " + id);
        }
        movies.remove(id);
    }

    @Override
    public Movie updateMovie(String id, Movie updatedMovie) {
        Movie existingMovie = movies.get(id);
        if (existingMovie == null) {
            throw new IdNotFoundException("No movie found with ID " + id);
        }
        updatedMovie.setId(id); // Ensure the ID remains the same
        movies.put(id, updatedMovie);
        return updatedMovie;
    }
}
