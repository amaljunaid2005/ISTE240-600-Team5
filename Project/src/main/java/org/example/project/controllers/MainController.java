package org.example.project.controllers;

import org.example.project.model.Movie;
import org.example.project.model.Ticket;
import org.example.project.services.MainService;
import org.example.project.service.DataService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private MainService mainService;
    private DataService dataService;

    public MainController(MainService mainService, DataService dataService) {
        this.mainService = mainService;
        this.dataService = dataService;
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
        model.addAttribute("tickets", dataService.getTickets());
        return "tickets";
    }

    @GetMapping("/tickets/add")
    public String addTicketPage(){
        return "add-ticket";
    }

    @PostMapping("/tickets/add")
    public String addTicket(Ticket ticket){
        dataService.addTicket(ticket);
        return "redirect:/add/success/ticket";
    }

    //user handler
    // User Handler
    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users", this.mainService.findAllUsers());
        return "users";
    }

    @GetMapping("/users/add")
    public String getUserForm(){
        return "add-user";
    }

    @PostMapping("/users/add")
    public String addUser(UserProfile user){
        this.mainService.saveUser(user);
        return "redirect:/add/success/users";
    }

}
