package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.model.entity.Movie;
import com.twu.biblioteca.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListMoviesCommandTest {
    @Mock
    private IOInterface io;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private ListMoviesCommand listMoviesCommand = new ListMoviesCommand(io);

    @Test
    public void shouldCallLibraryServiceToGetAllAvailableBooks() throws Exception {
        when(movieService.getAllActiveMovies()).thenReturn(new ArrayList<>());
        listMoviesCommand.execute();
        verify(movieService).getAllActiveMovies();
    }


    @Test
    public void shouldOutputNoActiveMoviesGivenEmptyList() throws Exception {
        when(movieService.getAllActiveMovies()).thenReturn(new ArrayList<>());
        listMoviesCommand.execute();
        verify(io).output(Constant.ALERT_NO_AVAIL_MOVIES);
    }


    @Test
    public void shouldOutputMoviesInfoGivenNotEmptyList() throws Exception {
        Movie movie = new Movie();
        when(movieService.getAllActiveMovies()).thenReturn(singletonList(movie));
        listMoviesCommand.execute();
        verify(io).output(movie.toString());
    }
}