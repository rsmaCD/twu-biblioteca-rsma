package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.service.LibraryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListBooksCommandTest {
    @Mock
    private IOInterface io;

    @Mock
    private LibraryService libraryService;

    @InjectMocks
    private ListBooksCommand listBooksCommand = new ListBooksCommand(io);

    @Test
    public void shouldCallLibraryService() throws Exception {
        listBooksCommand.execute();
        verify(libraryService).getAllActiveBooks();
    }
}