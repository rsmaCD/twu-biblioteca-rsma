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
public class RentBookCommandTest {

    @Mock
    private IOInterface io;

    @Mock
    private LibraryService libraryService;

    @Mock
    private CurrentUser instance;

    @InjectMocks
    private RentBookCommand rentBookCommand = new RentBookCommand(io);

    @Test
    public void shouldCallLibraryServiceToGetAllAvailableBooks() throws Exception {
        when(instance.isCurrentUserLogin()).thenReturn(true);
        when(io.getInput()).thenReturn("xxx");
        when(libraryService.isExistActiveBooks()).thenReturn(true);
        when(libraryService.rentBook("xxx")).thenReturn(true);
        rentBookCommand.execute();
        verify(libraryService).rentBook("xxx");
    }

    @Test
    public void shouldNotCallLibraryServiceToGetAllAvailableBooks() throws Exception {
        when(libraryService.isExistActiveBooks()).thenReturn(false);
        when(instance.isCurrentUserLogin()).thenReturn(true);
        rentBookCommand.execute();
        verify(libraryService, never()).rentBook("xxx");
    }

}