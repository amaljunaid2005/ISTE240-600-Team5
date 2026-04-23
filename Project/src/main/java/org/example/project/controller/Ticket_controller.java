package org.example.project.controller;

import org.example.project.model.Ticket;
import org.example.project.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins= "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable int id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/search")
    public List<Ticket> searchByUser(@RequestParam int userId) {
        return ticketService.getTicketsByUser(userId);
    }

    @GetMapping("/status")
    public List<Ticket> getByStatus(@RequestParam String value) {
        return ticketService.getTicketsByStatus(value);
    }

    @GetMapping("/movie/{movieId}")
    public List<Ticket> getByMovie(@PathVariable int movieId) {
        return ticketService.getTicketsByMovie(movieId);
    }

    @PostMapping
    public Ticket bookTicket(@RequestBody Ticket ticket) {
        return ticketService.bookTicket(ticket);
    }

     @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable int id,
                                               @RequestBody Ticket ticket) {
        Optional<Ticket> existing = ticketService.getTicketById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ticketService.updateTicket(id, ticket));
    }

      @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable int id) {
        Optional<Ticket> existing = ticketService.getTicketById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
 
