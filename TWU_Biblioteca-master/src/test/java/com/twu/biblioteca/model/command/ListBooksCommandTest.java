package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Book;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.model.entity.Movie;
import com.twu.biblioteca.service.LibraryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListBooksCommandTest {
    @Mock
    private IOInterface io;

    @Mock
    private LibraryService libraryService;

    @InjectMocks
    private ListBooksCommand listBooksCommand = new ListBooksCommand(io);

    @Test
    public void shouldCallLibraryServiceToGetAllAvailableBooks() throws Exception {
        listBooksCommand.execute();
        verify(libraryService).getAllActiveBooks();
    }

    @Test
    public void shouldOutputNoActiveBooksGivenEmptyList() throws Exception {
        when(libraryService.getAllActiveBooks()).thenReturn(new ArrayList<>());
        listBooksCommand.execute();
        verify(io).output(Constant.ALERT_NO_AVAIL_BOOKS);
    }


    @Test
    public void shouldOutputMoviesInfoGivenNotEmptyList() throws Exception {
        Book book = new Book();
        when(libraryService.getAllActiveBooks()).thenReturn(singletonList(book));
        listBooksCommand.execute();
        verify(io).output(book.toString());
    }
}