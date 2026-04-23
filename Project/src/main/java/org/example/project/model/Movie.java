package org.example.project.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/*
 * Represents a Movie that can be reviewed or added to a favorites list
 * Includes the name of the movie, its genre, director and lead actor as well as a short description of its premise.
 */
@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="movie_name", length = 100,nullable = false)
    private String movieName;

    @Column(name="year_of_release",length = 50, nullable = false)
    private int releaseYear;

    @Column(name="director",length = 50,nullable = false)
    private String director;

    @Column(name ="IMDB_rating",length = 5,nullable = false)
    private double rating;
    @Column(name="lead_actor",length = 100,nullable = false)
    private String leadActor;
    @Column(name="genre",length = 50,nullable = false)
    private String genre;
    @Column(name="description", nullable = false)
    private String description;

//    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.LAZY)
//    private List<Review> reviews = new ArrayList<Review>();
//
//    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.LAZY)
//    private List<Ticket> tickets = new ArrayList<Ticket>();

    public Movie (){};

    public Movie(String movieName,int releaseYear, String director, double rating, String leadActor, String genre, String description) {
        this.movieName = movieName;
        this.releaseYear=releaseYear;
        this.director = director;
        this.rating = rating;
        this.leadActor = leadActor;
        this.genre = genre;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }




    public String getMovieName() {
        return movieName;
    }



    public String getDirector() {
        return director;
    }



    public double getRating() {
        return rating;
    }



    public String getLeadActor() {
        return leadActor;
    }


}
