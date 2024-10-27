package com.example.MovieTicket.MovieBooking.Model;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Movie {

    @Min(value = 1, message = "ID must be at least 1")
    private String id;

    @NotBlank(message = "Movie name is required")
    @Size(min = 3, max = 20, message = "Movie name must be between 3 and 20 characters")
    private String movieName;

    @NotNull(message = "Movie director name is required")
    private String movieDirector;

    @Min(value = 1, message = "Movie rating must be at least 1")
    @Max(value = 10, message = "Movie rating must be at most 10")
    private long movieRating;

    
    private String movieLanguage;
    private List<String> writers;
    private List<String> actors;
    private List<String> genre;

    // Constructors
    public Movie() {
    }

    public Movie(String id, String movieName, String movieDirector, long movieRating, String movieLanguage, List<String> writers, List<String> actors, List<String> genre) {
        this.id = id;
        this.movieName = movieName;
        this.movieDirector = movieDirector;
        this.movieRating = movieRating;
        this.movieLanguage = movieLanguage;
        this.writers = writers;
        this.actors = actors;
        this.genre = genre;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public long getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(long movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    // Overriding toString() for better readability and debugging
    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieRating=" + movieRating +
                ", movieLanguage='" + movieLanguage + '\'' +
                ", writers=" + writers +
                ", actors=" + actors +
                ", genre=" + genre +
                '}';
    }

    
}
