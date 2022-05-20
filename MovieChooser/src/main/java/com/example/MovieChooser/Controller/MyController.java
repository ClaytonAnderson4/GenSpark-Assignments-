package com.example.MovieChooser.Controller;

import com.example.MovieChooser.Entity.Movie;
import com.example.MovieChooser.Service.MoviePService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private MoviePService moviePService;




    @GetMapping("/random")
    private Movie randomMovie(){
        return this.moviePService.getRandomMovie();
    }

    @GetMapping("/random/{movieYear}")
    private Movie randomMovieByYear(@PathVariable String movieYear){
        return this.moviePService.getRandomMovieByYear(movieYear);
    }


    @GetMapping("/movies")
    public List<Movie> movies(){
        return this.moviePService.getAllMovies();
    }


    @GetMapping("/movies/{movieID}")
    public Movie getMovie(@PathVariable String movieID){
        return this.moviePService.getMovieByID(Integer.parseInt(movieID));
    }


    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie){
        return this.moviePService.addMovie(movie);
    }

    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie){
        return this.moviePService.updateMovie(movie);
    }


    @DeleteMapping("/movies/{movieID}")
    public String deleteMoviebyID(@PathVariable String movieID){

        return this.moviePService.deleteMovieByID(Integer.parseInt(movieID));
    }


}
