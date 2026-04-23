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

    @Modifying
    @Query("update Movie m set m.releaseYear=:releaseYear where m.id=:id")
    int changeReleaseYear(@Param("id") int id, @Param("releaseYear") int releaseYear);

    @Modifying
    @Query("update Movie m set m.director=:director where m.id=:id")
    int changeDirector(@Param("id") int id, @Param("director") String director);

    @Modifying
    @Query("update Movie m set m.leadActor=:leadActor where m.id=:id")
    int changeLeadActor(@Param("id") int id, @Param("leadActor") String leadActor);

    @Modifying
    @Query("update Movie m set m.genre=:genre where m.id=:id")
    int changeGenre(@Param("id") int id, @Param("genre") String genre);

    @Modifying
    @Query("update Movie m set m.description=:description where m.id=:id")
    int changeDescription(@Param("id") int id, @Param("description") String description);

    //Delete methods
    void deleteById(long id);

    //to check if a record exists
    boolean existsById(int id);

}
