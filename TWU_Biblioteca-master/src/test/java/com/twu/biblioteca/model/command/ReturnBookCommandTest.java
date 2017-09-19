package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.repo.CurrentUser;
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
public class ReturnBookCommandTest {
    @Mock
    private IOInterface io;

    @Mock
    private LibraryService libraryService;

    @Mock
    private CurrentUser instance;

    @InjectMocks
    private ReturnBookCommand returnBookCommand = new ReturnBookCommand(io);

    @Test
    public void shouldCallLibraryServiceToReturnBook() throws Exception {
        when(instance.isCurrentUserLogin()).thenReturn(true);
        when(io.getInput()).thenReturn("xxx");
        when(libraryService.returnBook("xxx")).thenReturn(true);
        returnBookCommand.execute();
        verify(libraryService).returnBook("xxx");
    }
}