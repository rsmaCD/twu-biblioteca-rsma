package com.twu.biblioteca.repo;

import com.twu.biblioteca.model.entity.Movie;
import com.twu.biblioteca.model.entity.MovieRating;
import com.twu.biblioteca.model.enums.RentStatus;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class MovieRepo {

    private static final MovieRepo movieRepo = new MovieRepo();
    private List<Movie> movies;

    public static MovieRepo getInstance() {
        return movieRepo;
    }

    private MovieRepo() {
    }

    public void initMovieRepo() {
        Movie movie_1 = new Movie("movie_1", "2001", "diector_1", MovieRating.RATE_1, RentStatus.NOT_ON_RENT);
        Movie movie_2 = new Movie("movie_2", "2002", "diector_2", MovieRating.RATE_2, RentStatus.NOT_ON_RENT);
        Movie movie_3 = new Movie("movie_3", "2003", "diector_3", MovieRating.RATE_3, RentStatus.ON_RENT);
        Movie movie_4 = new Movie("movie_4", "2004", "diector_4", MovieRating.RATE_NONE, RentStatus.NOT_ON_RENT);

        movies = asList(movie_1, movie_2, movie_3, movie_4);
    }

    public List<Movie> getAllActiveMovies() {
        return movies.stream()
                .filter(movie -> movie.getRentStatus().equals(RentStatus.NOT_ON_RENT))
                .collect(Collectors.toList());
    }
}
