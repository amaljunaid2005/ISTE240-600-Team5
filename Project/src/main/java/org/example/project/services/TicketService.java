// GRISHMA BHANDARI 761001853

package org.example.project.services;

import org.example.project.models.Movie;
import org.example.project.models.Ticket;
import org.example.project.models.UserProfile;
import org.example.project.repositories.MovieRepository;
import org.example.project.repositories.TicketRepository;
import org.example.project.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UsersRepository userProfileRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public List<Ticket> getTicketsByUser(int userId) {
        UserProfile user = userProfileRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ticketRepository.findByUser(user);
    }

    public List<Ticket> searchByMovieTitle(String title) {
        return ticketRepository.findByMovieTitleContaining(title);
    }

    public Ticket bookTicket(int userId, int movieId, Ticket ticket) {
        UserProfile user = userProfileRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        ticket.setUser(user);
        ticket.setMovie(movie);

        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket updated) {
        Ticket existing = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        existing.setSeat(updated.getSeat());
        existing.setShowTime(updated.getShowTime());

        return ticketRepository.save(existing);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
}
