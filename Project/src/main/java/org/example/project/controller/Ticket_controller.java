package org.example.project.controller;

import org.example.project.model.Ticket;
import org.example.project.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable int id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);

        if(ticket.isPresent()){
            return ResponseEntity.ok(ticket.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public List<Ticket> searchByUser(@RequestParam int userID) {
        return ticketService.getTicketsByUser(userID);
    }

    @GetMapping("/status")
    public List<Ticket> getByStatus(@RequestParam String status) {
        return ticketService.getTicketsByStatus(status);
    }

    @GetMapping("/movie/{id}")
    public List<Ticket> getByMovie(@PathVariable int movieId) {
        return ticketService.getTicketsByMovie(movieId);
    }

    @PostMapping
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.bookTicket(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable int id, @RequestBody Ticket ticket) {
        Optional<Ticket> t = ticketService.getTicketById(id);

        if(t.isPresent()){
            Ticket updated = ticketService.updateTicket(id, ticket);
            return ResponseEntity.ok(updated);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTicket(@PathVariable int id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);

        if(ticket.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ticketService.deleteTicket(id);
        return ResponseEntity.ok().build();
    }
}
