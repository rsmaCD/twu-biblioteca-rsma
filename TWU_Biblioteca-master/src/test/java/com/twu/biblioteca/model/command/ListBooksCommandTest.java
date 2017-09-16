package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.service.LibraryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
        when(libraryService.isExistActiveBooks()).thenReturn(true);
        listBooksCommand.execute();
        verify(libraryService).getAllActiveBooks();
    }

    @Test
    public void shouldNotCallLibraryServiceToGetAllAvailableBooks() throws Exception {
        when(libraryService.isExistActiveBooks()).thenReturn(false);
        listBooksCommand.execute();
        verify(libraryService, never()).getAllActiveBooks();
    }
}