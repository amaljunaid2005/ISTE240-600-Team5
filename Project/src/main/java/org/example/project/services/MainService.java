package org.example.project.services;

import org.example.project.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    List<Movie> movieList = new ArrayList<Movie>();
    public MainService(){
        var movie1= new Movie("Matilda",1996,"Danny DeVito",7,"Mara Wilson","Family"," girl gifted with a keen intellect and psychic powers uses both to get even with her callous family and free her kindly schoolteacher from the tyrannical grip of a sadistic headmistress.");
        var movie2= new Movie("Midsommar",2019,"Ari Aster",7.1,"Florence Pugh","Horror","A couple travels to Northern Europe to visit a rural hometown's fabled Swedish mid-summer festival. What begins as an idyllic retreat quickly devolves into an increasingly violent and bizarre competition at the hands of a pagan cult.");
        this.movieList.add(movie1);
        this.movieList.add(movie2);
    }
    public List<Movie> findAllMovies(){return this.movieList;}
    public void saveMovie(Movie movie){this.movieList.add(movie);}
}
