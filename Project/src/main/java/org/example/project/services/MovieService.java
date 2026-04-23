package org.example.project.services;

import jakarta.transaction.Transactional;
import org.example.project.model.Movie;
import org.example.project.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService {
    @Autowired
    MovieRepository movieRepo;

    public Movie saveMovie(Movie movieToSave){
        return movieRepo.save(movieToSave);
    }

    public List<Movie> getAllMovies(){
        return movieRepo.findAll();
    }

    public Optional<Movie> getMovieById(int id){
        return movieRepo.findById(id);
    }

}
