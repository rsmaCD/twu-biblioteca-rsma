package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.service.LibraryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by rsma on 16/09/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class RentBookCommandTest {

    @Mock
    private IOInterface io;

    @Mock
    private LibraryService libraryService;

    @InjectMocks
    private RentBookCommand rentBookCommand = new RentBookCommand(io);

    @Test
    public void shouldCallLibraryService() throws Exception {
        when(io.getInput()).thenReturn("xxx");
        when(libraryService.rentBook("xxx")).thenReturn(true);
        rentBookCommand.execute();
        verify(libraryService).rentBook("xxx");
    }
}