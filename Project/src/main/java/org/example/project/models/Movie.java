package org.example.project.models;

/*
 * Represents a Movie that can be reviewed or added to a favorites list
 * Includes the name of the movie, its genre, director and lead actor as well as a short description of its premise.
 */
public class Movie {

    private int id;
    private String movieName;
    private int releaseYear;
    private String director;
    private double rating;
    private String leadActor;
    private String genre;
    private String description;

    public Movie (){};

    public Movie(int id,String movieName,int releaseYear, String director, double rating, String leadActor, String genre, String description) {

        this.id = id;
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

    public void setId(int id) {
        this.id = id;
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
