package org.example.project.services;

import org.example.project.model.Movie;
import org.example.project.model.Review;
import org.example.project.model.UserProfile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    List<Movie> movieList = new ArrayList<Movie>();
    List<UserProfile> userProfileList = new ArrayList<>();
    List<Review> reviewList = new ArrayList<>();

    private int reviewIdCounter = 4;

    public MainService(){

        // Movies
        var movie1= new Movie("Matilda",1996,"Danny DeVito",7,"Mara Wilson","Family"," girl gifted with a keen intellect and psychic powers uses both to get even with her callous family and free her kindly schoolteacher from the tyrannical grip of a sadistic headmistress.");
        var movie2= new Movie("Midsommar",2019,"Ari Aster",7.1,"Florence Pugh","Horror","A couple travels to Northern Europe to visit a rural hometown's fabled Swedish mid-summer festival. What begins as an idyllic retreat quickly devolves into an increasingly violent and bizarre competition at the hands of a pagan cult.");

        this.movieList.add(movie1);
        this.movieList.add(movie2);

        // Users
        var user1 = new UserProfile(1,"John");
        var user2 = new UserProfile(2,"Anna");

        this.userProfileList.add(user1);
        this.userProfileList.add(user2);

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
    }

    public List<Movie> findAllMovies(){return this.movieList;}
    public void saveMovie(Movie movie){this.movieList.add(movie);}

    // Getting and Adding reviews
    public List<Review> findAllReviews(){return this.reviewList;}
    public void saveReview(Review review){
        review.setId(reviewIdCounter++);
        this.reviewList.add(review);
    }
}
