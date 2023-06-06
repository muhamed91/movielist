package ch.hfu.movieapp.services;

import ch.hfu.movieapp.enums.Language;
import ch.hfu.movieapp.model.Movie;
import com.lilittlecat.chatgpt.offical.ChatGPT;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * This class implements the ChatPt service to return the answer
 *
 */

@Service
public class ChatGPTServiceImpl implements ChatGPTService {

    private final ChatGPT chatGPT;

    public ChatGPTServiceImpl(ChatGPT chatGPT) {
        this.chatGPT = chatGPT;
    }


    /**
     * Through this method we get the answer back if we ask ChatGpt for a question.
     * @param movie the movie which we want to have information
     * @param language the language on which we want to get the information
     *
     */
    @Override
    @Cacheable("movieDetail")
    public String getIntro(Movie movie, Language language) {

        String question = "";
        if(language.equals(Language.en)) {
            question += "Give me a description in the " +  language   +"  language  of the movie: " + movie.getTitle() + "from year: " + movie.getYear();
        } else if(language.equals(Language.de)) {
            question += "Gib mir eine beschreibung von dem  " +  movie.getTitle()   +"  film, bitte in der : " + language + "Sprache, und im welchen Jahr de rProduziert wurde " + movie.getYear();
        }

        return chatGPT.ask(question);

    }
}
