//GRISHMA BHANDARI 761001853

package org.example.project.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(name = "show_time")
    private LocalDateTime showTime;

    @Column(name = "seat")
    private String seat;

    @Column(name = "status")
    private String status;

    public Ticket() {}

    public Ticket(UserProfile user, int movieId, LocalDateTime showTime, String seat) {
        this.user = user;
        this.movieId = movieId;
        this.showTime = showTime;
        this.seat = seat;
        this.status = showTime.toLocalDate().isBefore(LocalDate.now())
                ? "previously_watched" : "going_to_watch";
    }
    public static String computeStatus(LocalDateTime showTime) {
    return showTime.toLocalDate().isBefore(LocalDate.now())
            ? "previously_watched" : "going_to_watch";
}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public LocalDateTime getShowTime() { return showTime; }
    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
        this.status = showTime.toLocalDate().isBefore(LocalDate.now())
                ? "previously_watched" : "going_to_watch";
    }

    public String getSeat() { return seat; }
    public void setSeat(String seat) { this.seat = seat; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
