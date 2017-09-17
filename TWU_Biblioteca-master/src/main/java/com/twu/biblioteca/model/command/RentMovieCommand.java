package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.service.MovieService;

import static com.twu.biblioteca.model.entity.Constant.ALERT_NO_AVAIL_MOVIES;
import static com.twu.biblioteca.model.entity.Constant.RENT_MOVIE_NOTICE;
import static com.twu.biblioteca.model.entity.Constant.RENT_MOVIE_SUCCESS_NOTICE;
import static com.twu.biblioteca.model.entity.Constant.RENT_MOVIE_WARNING;

public class RentMovieCommand implements Command{

    private IOInterface io;

    private MovieService movieService = new MovieService();

    public RentMovieCommand(IOInterface io) {
        this.io = io;
    }

    @Override
    public void execute() {
        if (!movieService.isExistActiveMovies()) {
            io.output(ALERT_NO_AVAIL_MOVIES);
        } else {
            io.output(RENT_MOVIE_NOTICE);
            rentMovie();
        }
    }

    private void rentMovie() {
        String movieName = io.getInput();
        if (movieService.rentMovie(movieName)) {
            io.output(RENT_MOVIE_SUCCESS_NOTICE);
        } else {
            io.output(RENT_MOVIE_WARNING);
            rentMovie();
        }
    }
}
