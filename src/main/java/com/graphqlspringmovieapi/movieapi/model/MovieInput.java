package com.graphqlspringmovieapi.movieapi.model;



import java.util.List;

public record MovieInput(
       String title,
        String director,
        String studio,
        String releaseYear,
        List<String> movieCast
) {
}
