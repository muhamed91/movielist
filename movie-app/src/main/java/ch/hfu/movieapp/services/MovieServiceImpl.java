package ch.hfu.movieapp.services;

import ch.hfu.movieapp.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the MovieService interface.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDatabaseImpl movieDatabase;

    /**
     * Retrieves the list of movies.
     *
     * @return The list of movies.
     */
    @Override
    public List<Movie> getMovieList() {
        return this.movieDatabase.getMovies();
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id The ID of the movie to retrieve.
     * @return The movie with the specified ID, or null if it doesn't exist.
     */
    @Override
    public Movie getMovie(Integer id) {
        return null;
    }

    /**
     * Adds a movie to the database.
     *
     * @param movie The movie to be added.
     */
    @Override
    public void addMovie(Movie movie) {

    }
}
