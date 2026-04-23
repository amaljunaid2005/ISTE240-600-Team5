package org.example.project.repositories;

import org.example.project.model.Movie;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    //Find methods, findAll already exists by default
    Optional<Movie> findById(int id);

    @Query("select m from Movie m where m.movieName=:name")
    List<Movie> findByMovieName(@Param("name") String name);

    //Update methods
    @Modifying
    @Query("update Movie m set m.movieName=:name where m.id=:id")
    int changeMovieName(@Param("id") int id, @Param("name") String name);

    //Delete methods
    void deleteById(long id);

}
