package com.twu.biblioteca.repo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MovieRepoTest {

    MovieRepo movieRepo = MovieRepo.getInstance();

    @Before
    public void setUp() throws Exception {
        movieRepo.initMovieRepo();
    }

    @Test
    public void shouldInitSuccess() throws Exception {
        assertNotNull(movieRepo.getAllActiveMovies());
        assertThat(movieRepo.getAllActiveMovies().size(),is(3));
    }

    @Test
    public void shouldGetAllActiveMovies() throws Exception {
        assertNotNull(movieRepo.getAllActiveMovies());
        assertThat(movieRepo.getAllActiveMovies().size(),is(3));
    }

    @Test
    public void shouldReturnFalseGivenInactiveBook() throws Exception {
        assertFalse(movieRepo.rentMovie("xxx"));
    }

    @Test
    public void shouldReturnTrueGivenActiveBook() throws Exception {
        assertTrue(movieRepo.rentMovie("movie_1"));
    }
}