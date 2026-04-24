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

    public List<Movie> getMovieByName(String name){
        return movieRepo.findByMovieName(name);
    }
    public Movie updateMovie(int id, Movie movieToUpdate){
        Movie movie = movieRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.setMovieName(movieToUpdate.getMovieName());
        movie.setDescription(movieToUpdate.getDescription());
        movie.setDirector(movieToUpdate.getDirector());
        movie.setGenre(movieToUpdate.getGenre());
        movie.setLeadActor(movieToUpdate.getLeadActor());
        movie.setReleaseYear(movieToUpdate.getReleaseYear());
        return movieRepo.save(movieToUpdate);
    }
}
