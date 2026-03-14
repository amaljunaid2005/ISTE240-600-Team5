package org.example.project.services;

import org.example.project.model.Movie;
import org.example.project.model.Ticket;
import org.example.project.model.UserProfile;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    List<Movie> movieList = new ArrayList<Movie>();

    private List<UserProfile> users = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public MainService(){

        var movie1= new Movie("Matilda",1996,"Danny DeVito",7,"Mara Wilson","Family"," girl gifted with a keen intellect and psychic powers uses both to get even with her callous family and free her kindly schoolteacher from the tyrannical grip of a sadistic headmistress.");
        var movie2= new Movie("Midsommar",2019,"Ari Aster",7.1,"Florence Pugh","Horror","A couple travels to Northern Europe to visit a rural hometown's fabled Swedish mid-summer festival. What begins as an idyllic retreat quickly devolves into an increasingly violent and bizarre competition at the hands of a pagan cult.");

        this.movieList.add(movie1);
        this.movieList.add(movie2);

        UserProfile user1 = new UserProfile(123,"john","john.abraham@gmail.com",20, "movie enthusiast , horror movie enjoyer");
        UserProfile user2 = new UserProfile(123,"alex","alex.abraham@gmail.com",20, "series enthusiast , romance movie enjoyer");

        users.add(user1);
        users.add(user2);

        Ticket t1 = new Ticket(1,user1,movie1,"2026-03-15 19:30");
        Ticket t2 = new Ticket(2,user2,movie2,"2026-03-16 21:00");

        tickets.add(t1);
        tickets.add(t2);
    }

    public List<Movie> findAllMovies(){
        return this.movieList;
    }

    public void saveMovie(Movie movie){
        this.movieList.add(movie);
    }

    public List<Ticket> findAllTickets(){
        return this.tickets;
    }

    public void saveTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public List<UserProfile> findAllUsers(){
        return this.users;
    }
}
