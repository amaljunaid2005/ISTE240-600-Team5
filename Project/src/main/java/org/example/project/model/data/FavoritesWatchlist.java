package org.example.project.model.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FavoritesWatchlist {

    private List<Movie> watchlist;
    private List<Movie> favorites;

    private UserProfile userProfile;

    @Autowired
    public FavoritesWatchlist(UserProfile userProfile) {
        this.userProfile = userProfile;
        this.watchlist = new ArrayList<Movie>();
        this.favorites = new ArrayList<Movie>();
    }

    public List<Movie> getWatchlist() {
        return watchlist;
    }

    public List<Movie> getFavorites() {
        return favorites;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void addToWatchlist(Movie movie) {
        watchlist.add(movie);
    }

    public void addToFavorites(Movie movie) {
        favorites.add(movie);
    }

    public void removeFromWatchlist(Movie movie) {
        watchlist.remove(movie);
    }

    public void removeFromFavorites(Movie movie) {
        favorites.remove(movie);
    }
}
