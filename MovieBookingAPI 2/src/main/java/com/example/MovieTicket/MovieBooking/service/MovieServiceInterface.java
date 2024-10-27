package com.example.MovieTicket.MovieBooking.service;

import java.util.List;
import java.util.Optional;

import com.example.MovieTicket.MovieBooking.Model.Movie;

public interface MovieServiceInterface {
    List<Movie> findAllMovies();
    Movie addMovie(Movie movie);
    Optional<Movie> findMovieById(String id);
    void deleteMovieById(String id);
    Movie updateMovie(String id, Movie movie);
}
