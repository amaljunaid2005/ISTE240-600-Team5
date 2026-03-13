package org.example.project.model;

import org.springframework.stereotype.Component;
/*
 * Represents a Movie that can be reviewed or added to a favorites list
 * Includes a unique id, the name of the movie, its genre, director and lead actor as well as a short description of its premise.
 */
public class Movie {
    private int id;
    private String movieName;
    private int releaseYear
    private String director;
    private double rating;
    private String leadActor;
    private String genre;
    private String description;

    public Movie(int id, String movieName,int releaseYear, String director, double rating, String leadActor, String genre, String description) {
        this.id = id;
        this.movieName = movieName;
        this.releaseYear=releaseYear;
        this.director = director;
        this.rating = rating;
        this.leadActor = leadActor;
        this.genre = genre;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }



    public String getGenre() {
        return genre;
    }



    public int getId() {
        return id;
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
