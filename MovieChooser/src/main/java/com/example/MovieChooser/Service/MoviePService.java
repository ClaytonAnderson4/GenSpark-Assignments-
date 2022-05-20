package com.example.MovieChooser.Service;

import com.example.MovieChooser.Entity.Movie;

import java.util.List;

public interface MoviePService {


    List<Movie> getAllMovies();
    Movie getMovieByID(int movieUMC);
    Movie addMovie(Movie movie);
    Movie updateMovie(Movie movie);
    String deleteMovieByID(int movieUMC);
    Movie getRandomMovie();
    Movie getRandomMovieByYear(String year);




}
