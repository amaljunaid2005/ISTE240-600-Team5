package org.example.project.controllers;

import org.example.project.model.Movie;
import org.example.project.services.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    // Review Pages
    @GetMapping("/reviews")
    public String getReviews(Model model){
        model.addAttribute("movieList", this.mainService.findAllMovies());
        return "reviews";
    }

    @GetMapping("/reviews/add")
    public String getReviewForm(){
        return "add-reviews";
    }

    @PostMapping("/reviews/add")
    public String addReview(Model data, Movie movie) {
        this.mainService.saveMovie(movie);
        data.addAttribute("movieList", this.mainService.findAllMovies());
        return "redirect:/add/success/reviews";
    }


}
