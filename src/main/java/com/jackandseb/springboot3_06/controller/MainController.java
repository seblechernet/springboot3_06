package com.jackandseb.springboot3_06.controller;

import com.jackandseb.springboot3_06.model.Director;
import com.jackandseb.springboot3_06.model.DirectorRepository;
import com.jackandseb.springboot3_06.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//@Controller
//public class MainController {
@RestController
public class MainController {

        @Autowired
        DirectorRepository directorRepository;

//    @RequestMapping("/")
//    public String index(Model model){
//
//        //first lets creeate a Director
//        Director director = new Director();
//        director.setName("Stephen Bullock");
//        director.setGenre("Sci Fi");
//
//        Movie movie = new Movie();
//        movie.setTitle("Star Movie");
//        movie.setYear(2017);
//        movie.setDescription("About the Stars...");
//
//        //add the movie to an empty list
//        Set<Movie> movies = new HashSet<Movie>();
//        movies.add(movie);
//
//        //Now we create another Movie
//        movie = new Movie();
//        movie.setTitle("Deathstar Ewoks");
//        movie.setYear(2011);
//        movie.setDescription("About Ewoks on the Death Star...");
//        movies.add(movie);
//
//        //add the list of movies to the director's movie list
//        director.setMovies(movies);
//
//        directorRepository.save(director);
//
//        //grab all the directors from the database and send them to the template
//        model.addAttribute("directors", directorRepository.findAll());
//        return "index";
//
//    }

    @RequestMapping("/")

    //to use html & thymeleaf use model
//    public String listofDirectors (Model model){

    //to use JSON model is not required && method returns Object(s)
    public Iterable<Director> listofDirectors (){

        //first lets creeate a Director
        Director director = new Director();
        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        Movie movie = new Movie();
        movie.setTitle("Star Movie");
        movie.setYear(2017);
        movie.setDescription("About the Stars...");
        movie.setDirector(director);

        //add the movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        //Now we create another Movie
        movie = new Movie();
        movie.setTitle("Deathstar Ewoks");
        movie.setYear(2011);
        movie.setDescription("About Ewoks on the Death Star...");
        movies.add(movie);
        movie.setDirector(director);

        //add the list of movies to the director's movie list
        director.setMovies(movies);

        directorRepository.save(director);

        //grab all the directors from the database and send them to the template
        //to use html && thymeleaf use Model and return webpage name
        //model.addAttribute("directors", directorRepository.findAll());
        //return "index";

        //for JSON return object(s)
        return directorRepository.findAll();

    }

}
