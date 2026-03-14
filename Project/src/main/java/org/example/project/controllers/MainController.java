package org.example.project.controllers;

import org.example.project.model.Movie;
import org.example.project.model.Ticket;
import org.example.project.services.MainService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private MainService mainService;


    public MainController(MainService mainService) {
        this.mainService = mainService;

    }

    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @GetMapping("/movies")
    public String getMovies(Model model){
        model.addAttribute("movieList", this.mainService.findAllMovies());
        return "movies";
    }

    @GetMapping("/movies/add")
    public String getMovieForm(){
        return "add-movie";
    }

    @GetMapping("/add/success/{entity}")
    public String success(@PathVariable String entity, Model model){
        model.addAttribute("entity",entity);
        return "success";
    }

    @PostMapping("/movies/add")
    public String addMovie(Model data, Movie movie) {
        this.mainService.saveMovie(movie);
        data.addAttribute("movieList", this.mainService.findAllMovies());
        return "redirect:/add/success/movies";
    }

    @GetMapping("/tickets")
    public String getTickets(Model model){
        model.addAttribute("tickets", mainService.findAllTickets());
        return "tickets";
    }

    @GetMapping("/tickets/add")
    public String addTicketPage(){
        return "add-ticket";
    }

    @PostMapping("/tickets/add")
    public String addTicket(Ticket ticket){
        mainService.saveTicket(ticket);
        return "redirect:/add/success/ticket";
    }

}
