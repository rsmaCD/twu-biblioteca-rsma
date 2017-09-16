package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NoCommandTest {
    @Mock
    private IOInterface io;

    @InjectMocks
    private NoCommand noCommand = new NoCommand(io);

    @Test
    public void shouldCallExit() throws Exception {
        noCommand.execute();
        verify(io).output(Constant.ERROR_COMMAND_MSG);
    }
}