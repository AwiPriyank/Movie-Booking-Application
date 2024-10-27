package com.example.MovieTicket.MovieBooking.controller;

import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFoundException;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Fetch list of all movies
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.findAllMovies();
    }

    // Add a new movie
    @PostMapping("/movie")
    public Movie addMovie(@Validated @RequestBody Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("Validation errors: " + bindingResult.getAllErrors());
        }
        return movieService.addMovie(movie);
    }

    // Fetch a movie by ID
    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable String id) {
        return movieService.findMovieById(id)
                .orElseThrow(() -> new IdNotFoundException("Movie not found with ID: " + id));
    }

    // Delete a movie by ID
    @DeleteMapping("/movie/{id}")
    public void deleteMovieById(@PathVariable String id) {
        movieService.deleteMovieById(id);
    }

    // Update a movie by ID
    @PutMapping("/update/{id}")
    public Movie updateMovie(@Validated @RequestBody Movie movie, @PathVariable String id) {
        return movieService.updateMovie(id, movie);
    }
}
