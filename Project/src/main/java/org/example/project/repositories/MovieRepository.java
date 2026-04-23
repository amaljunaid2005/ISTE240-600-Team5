package org.example.project.repositories;

import org.example.project.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    //Find methods, findAll already exists by default
    Optional<Movie> findById(long id);

    @Query("select m from Movie m where m.movieName=:name")
    List<Movie> findByMovieName(String name);



}
