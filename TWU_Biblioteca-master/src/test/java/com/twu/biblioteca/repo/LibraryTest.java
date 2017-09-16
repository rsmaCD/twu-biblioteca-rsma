package com.twu.biblioteca.repo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    Library library = Library.getInstance();

    @Test
    public void shouldInitSuccess() throws Exception {
        library.initLibrary();
        assertNotNull(library.getActiveBooks());
        assertNotNull(library.getInactiveBooks());
    }

    @Test
    public void shouldGetAllActiveBooks() throws Exception {
        library.initLibrary();
        assertNotNull(library.getActiveBooks());
        assertThat(library.getActiveBooks().size(), is(3));
    }

    @Test
    public void shouldGetAllInactiveBooks() throws Exception {
        library.initLibrary();
        assertNotNull(library.getInactiveBooks());
        assertThat(library.getInactiveBooks().size(), is(1));
    }
}