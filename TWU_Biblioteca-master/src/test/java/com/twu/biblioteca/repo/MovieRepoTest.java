package com.twu.biblioteca.repo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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


}