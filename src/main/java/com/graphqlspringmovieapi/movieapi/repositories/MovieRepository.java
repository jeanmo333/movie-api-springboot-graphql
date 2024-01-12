package com.graphqlspringmovieapi.movieapi.repositories;

import com.graphqlspringmovieapi.movieapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
