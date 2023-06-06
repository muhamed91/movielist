package ch.hfu.movieapp.services;

import ch.hfu.movieapp.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of the MovieDatabase interface.
 */
@Service
public class MovieDatabaseImpl implements MovieDatabse {

    private  int id = 0;
    private List<Movie> movies = new ArrayList<Movie>();

    /**
     * Retrieves the list of movies.
     *
     * @return The list of movies.
     */
    @Override
    public List<Movie> getMovies() {

        return movies;
    }


    /**
     * Adds a movie to the database.
     *
     * @param movie The movie to be added.
     */
    public void addMovie(Movie movie) {
        movie.setId(id);
        movies.add(movie);
        id++;
    }

    public int getNextId() {
        return ++id;
    }
}
