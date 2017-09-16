package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginCommandTest {

    @Mock
    private IOInterface io;

    @Mock
    private UserService userService;

    @InjectMocks
    private LoginCommand loginCommand = new LoginCommand(io);

    @Test
    public void shouldCallUserServiceToCheckLibraryNumAndPasswordMatch() throws Exception {
        when(io.getInput()).thenReturn("1");
        when(userService.checkLibraryNumAndPasswordMatch("1","1")).thenReturn(true);
        loginCommand.execute();
        verify(userService).checkLibraryNumAndPasswordMatch("1","1");
    }
}