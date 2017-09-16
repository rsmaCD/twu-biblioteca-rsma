package com.twu.biblioteca.service;

import com.twu.biblioteca.model.entity.Book;
import com.twu.biblioteca.repo.Library;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LibraryServiceTest {

    @Mock
    private Library library;
    @InjectMocks
    private LibraryService libraryService = new LibraryService();

    @Test
    public void shouldReturnAllActiveBooksWhenCallGetAllActiveBooks() throws Exception {
        ArrayList<Book> books = new ArrayList<>();
        when(library.getActiveBooks()).thenReturn(books);
        List<Book> allActiveBooks = libraryService.getAllActiveBooks();
        assertThat(allActiveBooks,is(books));
    }

    @Test
    public void shouldCallRentBook() throws Exception {
        when(library.rentBook("xxx")).thenReturn(true);
        assertTrue(libraryService.rentBook("xxx"));
    }

    @Test
    public void shouldCallReturnBook() throws Exception {
        when(library.returnBook("xxx")).thenReturn(true);
        assertTrue(libraryService.returnBook("xxx"));
    }
}