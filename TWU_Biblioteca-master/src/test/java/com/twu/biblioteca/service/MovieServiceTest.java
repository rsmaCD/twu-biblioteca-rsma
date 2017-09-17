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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
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
}