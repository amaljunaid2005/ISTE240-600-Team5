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
    public void updateMovie(int id, Movie movieToUpdate){
        if (movieRepo.existsById(id))
        {movieRepo.changeMovieName(id,movieToUpdate.getMovieName());
            movieRepo.changeDescription(id,movieToUpdate.getDescription());
            movieRepo.changeDirector(id,movieToUpdate.getDirector());
            movieRepo.changeGenre(id,movieToUpdate.getGenre());
            movieRepo.changeReleaseYear(id,movieToUpdate.getReleaseYear());
            movieRepo.changeLeadActor(id,movieToUpdate.getLeadActor());}
        else{
            throw new RuntimeException("This movie does not exist in database");
        }
    }
}
