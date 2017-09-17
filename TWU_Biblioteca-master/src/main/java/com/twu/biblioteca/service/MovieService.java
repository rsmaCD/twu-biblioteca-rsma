package com.twu.biblioteca.service;

import com.twu.biblioteca.model.entity.Movie;
import com.twu.biblioteca.repo.MovieRepo;

import java.util.List;

public class MovieService {

    private MovieRepo movieRepo = MovieRepo.getInstance();

    public List<Movie> getAllActiveMovies() {
        return movieRepo.getAllActiveMovies();
    }
}