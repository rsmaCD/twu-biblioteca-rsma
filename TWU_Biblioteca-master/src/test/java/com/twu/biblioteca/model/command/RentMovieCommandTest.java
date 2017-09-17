package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RentMovieCommandTest {

    @Mock
    private IOInterface io;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private RentMovieCommand rentMovieCommand = new RentMovieCommand(io);

    @Test
    public void shouldCallMovieServiceToGetAllAvailableMovies() throws Exception {
        when(io.getInput()).thenReturn("xxx");
        when(movieService.isExistActiveMovies()).thenReturn(true);
        when(movieService.rentMovie("xxx")).thenReturn(true);
        rentMovieCommand.execute();
        verify(movieService).rentMovie("xxx");
    }

    @Test
    public void shouldNotCallLibraryServiceToGetAllAvailableBooks() throws Exception {
        when(movieService.isExistActiveMovies()).thenReturn(false);
        rentMovieCommand.execute();
        verify(movieService, never()).rentMovie("xxx");
    }

}