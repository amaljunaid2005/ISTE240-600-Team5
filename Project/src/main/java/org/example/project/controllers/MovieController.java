package org.example.project.controllers;

import org.example.project.model.Movie;
import org.example.project.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/api/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies=this.movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/api/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable int id){
        Optional<Movie> movie=this.movieService.getMovieById(id);
        if(movie.isPresent())
            return new ResponseEntity<Movie>(movie.get(), HttpStatus.OK);
        else
            return new ResponseEntity<Movie>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("api/movies/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String name){
        return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.OK);
    }

}
