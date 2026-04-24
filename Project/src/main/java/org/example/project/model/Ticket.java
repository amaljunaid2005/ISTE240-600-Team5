package org.example.project.model;

public class Ticket {

    private int id;
    private UserProfile user;
    private Movie movie;
    private String showTime;

    public Ticket(int id, UserProfile user, Movie movie, String showTime) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.showTime = showTime;
    }

    public Ticket() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
