package ch.hfu.movieapp.controller;

import ch.hfu.movieapp.enums.Language;
import ch.hfu.movieapp.model.Movie;
import ch.hfu.movieapp.services.ChatGPTServiceImpl;
import ch.hfu.movieapp.services.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controller class for handling movie related operations.
 */
@Controller
public class MovieController {

    @Value("${application.default.lang}")
    private String defaultLang;
    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private ChatGPTServiceImpl chatGPTService;

    /**
     * On Start redirect to movie list
     */
    @GetMapping("/")
    public RedirectView redirectViewToMovies() {
        String language = defaultLang;
        String redirectUrl = "/movie/" + language + "/liste";
        return new RedirectView(redirectUrl);
    }

    /**
     * Retrieves the movie list for the specified language and generates an HTML representation of it.
     *
     * @param language The language for which the movie list is requested.
     * @return The HTML representation of the movie list.
     */
    @GetMapping({"/movie/{language}/liste"})
    @ResponseBody
    public String movieList(@PathVariable() Language language){
        String selectedLanguage= this.choosenLanguage(language);
        return "<html><head> <title>Film Liste</title> </head> <body> <h1>Film Liste</h1> <ul>"+  this.generateMovieListHTML(language) + "</ul>  <p><a href=/movie/" + selectedLanguage +"/liste>Zum " + selectedLanguage + "</a></p> </body></html>";
    }

    private String generateMovieListHTML(Language language) {
        String movieListHTML = "";
        for (Movie movie :this.movieService.getMovieList()) {
            movieListHTML += "<li>" + "<a" + " " + "href=/movie/"+language +"/get/" + movie.getId() + "> "+ movie.getTitle() + " (" + movie.getYear() + ")</a></li>";
        }
        return movieListHTML;
    }

    /**
     * Retrieves the movie details informatin for the specified language and generates an HTML representation of it.
     * Call also the CHatGpt Service to get the information
     * @param language The language for which the movie list is requested.
     * @return The HTML representation of the movie list.
     */
    @GetMapping({"/movie/{language}/get/{id}"})
    @ResponseBody
    public String movieDetail(@PathVariable("language") Language language, @PathVariable("id") int id){
        Movie foundMovie = null;
        for (Movie movie :this.movieService.getMovieList()) {
            if ((movie.getId() == id)) {
                foundMovie = movie;
                break;
            }
        }

        String backTolistCaption = "";
        String movieYearCaption = "";
        if(language.equals(Language.de)) {
            backTolistCaption += "Zurück zur Liste";
            movieYearCaption += "Jahr";
        } else if (language.equals(Language.en)) {
            backTolistCaption += "back to list";
            movieYearCaption += "Year";
        } else {
            backTolistCaption += "zurück zur Liste";
            movieYearCaption += "Jahr";
        }

        String choosenLang = this.choosenLanguage(language);
        String urlBuilder = "/movie/" + choosenLang +"/get/"+id;

       String introText = this.chatGPTService.getIntro(foundMovie, language);

        return "<html><head> <title>Film Liste</title> </head> <body> <h1>Film Liste Detail</h1><h2>" + foundMovie.getTitle() + "</h2> <p>" + introText +  "</p> <p>" + movieYearCaption+ ":" + foundMovie.getYear() + "<p> <a href=/movie/" + language +"/liste>" + backTolistCaption + "</a></p><p><a href=" + urlBuilder +">Zum " + choosenLang +"</a></p></body></html>";
    }

    private String choosenLanguage(Language language) {
        String choosenLanguage = "";
        if(language.equals(Language.de)) {
            choosenLanguage = "en";
        } else  {
            choosenLanguage = "de";
        }
        return choosenLanguage;
    }



}
