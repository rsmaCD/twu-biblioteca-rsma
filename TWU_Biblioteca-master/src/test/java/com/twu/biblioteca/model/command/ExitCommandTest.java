package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ExitCommandTest {

    @Mock
    private IOInterface io;

    @InjectMocks
    private ExitCommand exitCommand = new ExitCommand(io);

    @Test
    public void shouldCallExit() throws Exception {
        exitCommand.execute();
        verify(io).exit();
    }
}