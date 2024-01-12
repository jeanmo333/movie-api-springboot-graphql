package com.graphqlspringmovieapi.movieapi.exceptions;


import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler
    public GraphQLError handleMovieNotFoundException(MovieNotFoundException ex){
        return GraphQLError.newError().message(ex.getMessage()).build();
    }
}
