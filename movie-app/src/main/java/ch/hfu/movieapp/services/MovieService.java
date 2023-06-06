package ch.hfu.movieapp.services;

import ch.hfu.movieapp.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getMovieList();
    Movie getMovie(Integer id);
    void addMovie(Movie movie);

}
