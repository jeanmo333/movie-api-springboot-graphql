package com.graphqlspringmovieapi.movieapi.controllers;

import com.graphqlspringmovieapi.movieapi.model.Movie;
import com.graphqlspringmovieapi.movieapi.model.MovieInput;
import com.graphqlspringmovieapi.movieapi.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MovieController {
    private final MovieService movieService;

    @QueryMapping
    public List<Movie> getAllMoviesHandler(){
        return movieService.getAllMovies();
    }



    @MutationMapping
    public Movie addMovieHandler( @Argument MovieInput movieInput){
        return movieService.addMovie(movieInput);
    }

    @MutationMapping
    public Movie updateMovieHandler(
            @Argument Long id,
            @Argument MovieInput movieInput){
        return movieService.updateMovie(id,movieInput);
    }


    @MutationMapping
    public String deleteMovieHandler(
            @Argument Long id){
        return movieService.deleteMovie(id);
    }
}
