package org.example.project.controllers;

import org.example.project.model.Movie;
import org.example.project.model.Review;
import org.example.project.model.Ticket;
import org.example.project.model.UserProfile;
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
    // success page handler
    @GetMapping("/add/success/{entity}")
    public String success(@PathVariable String entity, Model model){
        model.addAttribute("entity",entity);
        return "success";
    }
    //movie handler
    @GetMapping("/movies")
    public String getMovies(Model model){
        model.addAttribute("movieList", this.mainService.findAllMovies());
        return "movies";
    }

    @GetMapping("/movies/add")
    public String getMovieForm(){
        return "add-movie";
    }



    @PostMapping("/movies/add")
    public String addMovie(Model data, Movie movie) {
        this.mainService.saveMovie(movie);
        data.addAttribute("movieList", this.mainService.findAllMovies());
        return "redirect:/add/success/movies";
    }

    // Review Handler
    @GetMapping("/reviews")
    public String getReviews(Model model){
        model.addAttribute("reviewList", this.mainService.findAllReviews());
        return "reviews";
    }

    @GetMapping("/reviews/add")
    public String getReviewForm(Model model){
        model.addAttribute("users", mainService.findAllUsers());
        model.addAttribute("movies", mainService.findAllMovies());
        return "add-review";
    }

    @PostMapping("/reviews/add")
    public String addReview( @RequestParam int userId,  @RequestParam int movieId, Review review) {
        this.mainService.saveReview(review, userId, movieId);
        return "redirect:/add/success/reviews";
    }

    // Ticket Handler
    @GetMapping("/tickets")
    public String getTickets(Model model){
        model.addAttribute("tickets", mainService.findAllTickets());
        return "tickets";
    }

    @GetMapping("/tickets/add")
    public String addTicketPage(Model model){
        model.addAttribute("users", mainService.findAllUsers());
        model.addAttribute("movies", mainService.findAllMovies());
        return "add-ticket";
    }

    @PostMapping("/tickets/add")
    public String addTicket(@RequestParam int userId,@RequestParam int movieId, Ticket ticket){
        mainService.saveTicket(ticket,userId,movieId);
        return "redirect:/add/success/tickets";
    }

    // User Handler
    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users", this.mainService.findAllUsers());
        return "user";
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
