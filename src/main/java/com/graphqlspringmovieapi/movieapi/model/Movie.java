package com.graphqlspringmovieapi.movieapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "movies")
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String director;

    private String studio;

    @Column(name = "release_year")
    private String releaseYear;


    @ElementCollection
    @CollectionTable(name = "movie_cast")
    private List<String> movieCast;

    public Movie(String title, String director, String studio, String releaseYear, List<String> movieCast) {
        this.title = title;
        this.director = director;
        this.studio = studio;
        this.releaseYear = releaseYear;
        this.movieCast = movieCast;
    }
}
