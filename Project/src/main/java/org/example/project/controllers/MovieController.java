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

    //searching for movie by name
    @GetMapping("api/movies/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String name){
        List<Movie> search_result=movieService.getMovieByName(name);
        return new ResponseEntity<>(search_result, HttpStatus.OK);
    }

    //creating a new movie
    @PostMapping("/api/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        try{
            Movie movieToSave=movieService.saveMovie(movie);
            return new ResponseEntity<>(movieToSave, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //updating an existing movie
    @PutMapping("/api/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie movie){
        try{
            return new ResponseEntity<>(movieService.updateMovie(id,movie), HttpStatus.OK);
        }
        catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    //deleting a record
    @DeleteMapping("/api/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id){
        Optional<Movie> movieExists =movieService.getMovieById(id);

        if(movieExists.isPresent()){
            movieService.deleteMovie(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
