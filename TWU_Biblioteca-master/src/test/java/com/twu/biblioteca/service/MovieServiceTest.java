package com.twu.biblioteca.service;

import com.twu.biblioteca.model.entity.Movie;
import com.twu.biblioteca.repo.MovieRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @Mock
    private MovieRepo movieRepo;
    @InjectMocks
    private MovieService movieService = new MovieService();

    @Test
    public void shouldReturnAllActiveMoviesWhenCallGetAllActiveMovies() throws Exception {
        ArrayList<Movie> movies = new ArrayList<>();
        when(movieRepo.getAllActiveMovies()).thenReturn(movies);
        List<Movie> allActiveMovies = movieService.getAllActiveMovies();
        assertThat(allActiveMovies, is(movies));
    }

    @Test
    public void shouldCallRentBook() throws Exception {
        when(movieRepo.rentMovie("xxx")).thenReturn(true);
        assertTrue(movieRepo.rentMovie("xxx"));
    }

    @Test
    public void shouldReturnFalseWhenNoActiveBookInLibrary() throws Exception {
        ArrayList<Movie> movies = new ArrayList<>();
        when(movieRepo.getAllActiveMovies()).thenReturn(movies);
        assertFalse(movieService.isExistActiveMovies());
    }

    @Test
    public void shouldReturnTrueWhenHasActiveBookInLibrary() throws Exception {
        List<Movie> movies = singletonList(new Movie());
        when(movieRepo.getAllActiveMovies()).thenReturn(movies);
        assertTrue(movieService.isExistActiveMovies());
    }
}