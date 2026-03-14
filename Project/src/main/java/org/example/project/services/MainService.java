package org.example.project.services;

import org.example.project.model.Movie;
import org.example.project.model.Review;
import org.example.project.model.UserProfile;
import org.example.project.model.Ticket;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    List<Movie> movieList = new ArrayList<Movie>();
    List<UserProfile> userList = new ArrayList<>();
    List<Review> reviewList = new ArrayList<>();
    List<Ticket> tickets = new ArrayList<>();

    private int reviewIdCounter = 4;
    private int movieIdCounter = 3;

    public MainService(){

        // Movies
        var movie1= new Movie(1, "Matilda",1996,"Danny DeVito",7,"Mara Wilson","Family"," girl gifted with a keen intellect and psychic powers uses both to get even with her callous family and free her kindly schoolteacher from the tyrannical grip of a sadistic headmistress.");
        var movie2= new Movie(2, "Midsommar",2019,"Ari Aster",7.1,"Florence Pugh","Horror","A couple travels to Northern Europe to visit a rural hometown's fabled Swedish mid-summer festival. What begins as an idyllic retreat quickly devolves into an increasingly violent and bizarre competition at the hands of a pagan cult.");

        this.movieList.add(movie1);
        this.movieList.add(movie2);

        // Users
        var user1 = new UserProfile(1,"John", "jhn1324@gmail.com", 35, "@ghTdk21", "Just a regular movie fan sharing honest opinions on what’s worth watching and what isn’t.");
        var user2 = new UserProfile(2,"Anna", "ann.mary12@gmail.com", 20, "fnF@234!", "College student and movie enthusiast sharing quick reviews and ratings after every watch.");

        this.userList.add(user1);
        this.userList.add(user2);

        // Reviews
        var review1 = new Review(1, "Really enjoyable. Have watched this multiple times. Feel good family film. Good performances.", 7, user1, movie1);
        var review2 = new Review(2, "It captures the essence of heartwarming fun with " +
                "heartwarming humor, but I guess anything with Danny DeVito in it is going to be good, (besides Jumanji: The Next Level). " +
                "He's a legend and we were lucky to have him.", 10, user2, movie1);
        var review3 = new Review(3, "Didn't expect anything from this movie, but it failed to " +
                "delivery even the slightest bit. The characters are unrelatable and unsympathetic, so you " +
                "don't really care if they live or not. The singing, dancing, moaning really puts you off the " +
                "suspense path, so the movie doesn't even feel scary, just a bit disturbing and popping the question \"why the hell am I wasting my time on this?\"", 7, user2, movie2);

        this.reviewList.add(review1);
        this.reviewList.add(review2);
        this.reviewList.add(review3);

        // Tickets
        Ticket t1 = new Ticket(1,user1,movie1,"2026-03-15 19:30");
        Ticket t2 = new Ticket(2,user2,movie2,"2026-03-16 21:00");

        tickets.add(t1);
        tickets.add(t2);
    }

    // Getting and Adding movies
    public List<Movie> findAllMovies(){return this.movieList;}

    public void saveMovie(Movie movie){
        movie.setId(movieIdCounter++);
        this.movieList.add(movie);
    }

    // Getting and Adding movies
    public List<UserProfile> findAllUsers(){
        return this.userList;
    }

    public void saveUser(UserProfile user){this.userList.add(user);}

    // Identifying users and movies by a unique ID
    public UserProfile findUserById(int id) {
        for (UserProfile user : userList) {
            if (user.getUserID() == id) {
                return user;
            }
        }
        return null;
    }
    public Movie findMovieById(int id) {
        for (Movie movie : movieList) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }
    // Getting and Adding reviews
    public List<Review> findAllReviews(){return this.reviewList;}

    public void saveReview(Review review, int userId, int movieId) {

        UserProfile user = findUserById(userId);
        Movie movie = findMovieById(movieId);

        review.setUserProfile(user);
        review.setMovie(movie);

        review.setId(reviewIdCounter++);

        this.reviewList.add(review);
    }

    // Getting and Adding tickets
    public List<Ticket> findAllTickets(){
        return this.tickets;
    }

    public void saveTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    }



