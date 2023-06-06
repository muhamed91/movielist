package ch.hfu.movieapp.services;

import ch.hfu.movieapp.enums.Language;
import ch.hfu.movieapp.model.Movie;

public interface ChatGPTService {
    String getIntro(Movie movie, Language language);
}
