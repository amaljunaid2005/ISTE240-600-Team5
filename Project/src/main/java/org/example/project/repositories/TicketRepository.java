//GRISHMA BHANDARI 761001853
package org.example.project.repositories;

import org.example.project.models.Ticket;
import org.example.project.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByUser(UserProfile user);

    @Query("SELECT t FROM Ticket t WHERE LOWER(t.movie.movieName) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Ticket> findByMovieTitleContaining(@Param("title") String title);
}
