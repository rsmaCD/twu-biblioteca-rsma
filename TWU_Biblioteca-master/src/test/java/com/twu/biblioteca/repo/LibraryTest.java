package com.twu.biblioteca.repo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    Library library = Library.getInstance();

    @Before
    public void setUp() throws Exception {
        library.initLibrary();
    }

    @Test
    public void shouldInitSuccess() throws Exception {

        assertNotNull(library.getActiveBooks());
        assertNotNull(library.getInactiveBooks());
    }

    @Test
    public void shouldGetAllActiveBooks() throws Exception {
        assertNotNull(library.getActiveBooks());
        assertThat(library.getActiveBooks().size(), is(3));
    }

    @Test
    public void shouldGetAllInactiveBooks() throws Exception {
        assertNotNull(library.getInactiveBooks());
        assertThat(library.getInactiveBooks().size(), is(1));
    }

    @Test
    public void shouldReturnFalseGivenInactiveBook() throws Exception {
        assertFalse(library.rentBook("xxx"));
    }

    @Test
    public void shouldReturnTrueGivenActiveBook() throws Exception {
        assertTrue(library.rentBook("book_1"));
    }
}