// Grishma Bhandari 761001853
package org.example.project.controllers;

import org.example.project.models.Ticket;
import org.example.project.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getById(@PathVariable Long id) {
        return ticketService.getTicketById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ FIXED: int instead of Long
    @GetMapping("/user/{userId}")
    public List<Ticket> getByUser(@PathVariable int userId) {
        return ticketService.getTicketsByUser(userId);
    }

 

    @GetMapping("/search")
    public List<Ticket> search(@RequestParam String title) {
        return ticketService.searchByMovieTitle(title);
    }

    @PostMapping
    public Ticket bookTicket(@RequestParam int userId,
                             @RequestParam int movieId,
                             @RequestBody Ticket ticket) {
        return ticketService.bookTicket(userId, movieId, ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id,
                                               @RequestBody Ticket ticket) {
        if (ticketService.getTicketById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ticketService.updateTicket(id, ticket));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        if (ticketService.getTicketById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
