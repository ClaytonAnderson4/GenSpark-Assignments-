package com.example.MovieChooser.Service;

import com.example.MovieChooser.DAO.MovieDAO;
import com.example.MovieChooser.Entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MoviePServiceImpl implements MoviePService{

    @Autowired
    private MovieDAO movieDAO;


    @Override
    public List<Movie> getAllMovies() {
        return this.movieDAO.findAll();
    }

    @Override
    public Movie getMovieByID(int movieUMC) {
        Optional<Movie> m = this.movieDAO.findById(movieUMC);
        Movie movie = null;
        if(m.isPresent()){
            movie = m.get();
        }else{
            throw new RuntimeException("Movie not found for UMC :: " + movieUMC);
        }

        return movie;

    }

    @Override
    public Movie addMovie(Movie movie) {
        return this.movieDAO.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return this.movieDAO.save(movie);
    }

    @Override
    public String deleteMovieByID(int movieUMC) {
        this.movieDAO.deleteById(movieUMC);
        return "Movie: " + movieUMC + " Deleted";
    }

    @Override
    public Movie getRandomMovie() {
        List<Movie> allMovies = this.movieDAO.findAll();
        Random rand = new Random();
        return allMovies.get(rand.nextInt(allMovies.size()));
    }

    @Override
    public Movie getRandomMovieByYear(String year) {
        List<Movie> allMovies = this.movieDAO.findAll();
        List<Movie> moviesByYear = new ArrayList<>();
        for(Movie m:allMovies){
            if(m.getYear().equals(year)){
                moviesByYear.add(m);
            }
        }

        Random rand = new Random();
        return moviesByYear.get(rand.nextInt(moviesByYear.size()));
    }
}
