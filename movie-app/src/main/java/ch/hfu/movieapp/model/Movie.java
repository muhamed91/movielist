package ch.hfu.movieapp.model;

/**
 * Represents a movie.
 */
public class Movie {
    /**
     * The ID of the movie.
     */
    private int id;

    /**
     * The title of the movie.
     */
    private final String title;

    /**
     * The year of release of the movie.
     */
    private final int year;

    /**
     * Constructs a new Movie with the specified ID, title, and year.
     *
     * @param id    The ID of the movie.
     * @param title The title of the movie.
     * @param year  The year of release of the movie.
     */
    public Movie(int id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    /**
     * Retrieves the ID of the movie.
     *
     * @return The ID of the movie.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the movie.
     *
     * @param id The ID of the movie.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the title of the movie.
     *
     * @return The title of the movie.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the year of release of the movie.
     *
     * @return The year of release of the movie.
     */
    public int getYear() {
        return year;
    }
}
