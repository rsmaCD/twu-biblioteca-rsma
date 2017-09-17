package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.model.entity.Movie;
import com.twu.biblioteca.service.MovieService;

import java.util.List;

public class ListMoviesCommand implements Command {

    private IOInterface io;

    private MovieService movieService = new MovieService();

    public ListMoviesCommand(IOInterface io) {
        this.io = io;
    }

    @Override
    public void execute() {
        listMovies();
    }

    private void listMovies() {
        List<Movie> movies = movieService.getAllActiveMovies();
        if (movies.size() != 0) {
            for (Movie movie : movies) {
                io.output(movie.toString());
            }
        } else {
            io.output(Constant.ALERT_NO_AVAIL_MOVIES);
        }
    }
}
