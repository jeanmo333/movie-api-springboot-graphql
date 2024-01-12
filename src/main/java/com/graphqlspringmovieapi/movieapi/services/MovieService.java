package com.graphqlspringmovieapi.movieapi.services;

import com.graphqlspringmovieapi.movieapi.exceptions.MovieNotFoundException;
import com.graphqlspringmovieapi.movieapi.model.Movie;
import com.graphqlspringmovieapi.movieapi.model.MovieInput;
import com.graphqlspringmovieapi.movieapi.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie addMovie(MovieInput movieInput){
        Movie movie = new Movie(
                movieInput.title(),
                movieInput.studio(),
                movieInput.director(),
                movieInput.releaseYear(),
                movieInput.movieCast()
        );

        return movieRepository.save(movie);

    }


    public Movie updateMovie(Long id, MovieInput movieInput){
        Movie movie = movieRepository.findById(id).orElseThrow(()-> new MovieNotFoundException("movie not Exit"));

        movie.setTitle(movieInput.title());
        movie.setDirector(movieInput.director());
        movie.setStudio(movieInput.studio());
        movie.setReleaseYear(movieInput.releaseYear());
        movie.setMovieCast(movieInput.movieCast());

        return movieRepository.save(movie);
    }


    public String deleteMovie(Long id){
        Movie movie = movieRepository.findById(id).orElseThrow(()-> new MovieNotFoundException("movie not Exit"));

        movieRepository.delete(movie);

        return "movie delete successfuly";
    }
}
