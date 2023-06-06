package ch.hfu.movieapp.runner;

import ch.hfu.movieapp.model.Movie;
import ch.hfu.movieapp.services.MovieDatabaseImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * A command line runner that adds movies to the movie database when the application starts.
 */
@Component
public class ApplicationStartedRunner implements CommandLineRunner {

    private final MovieDatabaseImpl movieDatabase;

    /**
     * Constructs a new ApplicationStartedRunner with the specified MovieDatabaseImpl.
     *
     * @param movieDatabase The MovieDatabaseImpl to be used.
     */
    public ApplicationStartedRunner(MovieDatabaseImpl movieDatabase) {
        this.movieDatabase = movieDatabase;
    }

    @Override
    public void run(String... args) throws Exception {

        try {
            this.movieDatabase.addMovie(new Movie(this.movieDatabase.getNextId(), "The Departed", 2006));
            this.movieDatabase.addMovie(new Movie(this.movieDatabase.getNextId(), "The Matrix Reloaded", 2003));
            this.movieDatabase.addMovie(new Movie(this.movieDatabase.getNextId(), "Ali G in da House", 2002));
            this.movieDatabase.addMovie(new Movie(this.movieDatabase.getNextId(), "Avatar – Aufbruch nach Pandora", 2009));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
