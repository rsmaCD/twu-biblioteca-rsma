package com.twu.biblioteca.model.status;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainMenuCommandTest {

    @Mock
    private IOInterface io;

    @InjectMocks
    private MainMenuCommand mainMenuCommand = new MainMenuCommand(io);

    @Test
    public void shouldCallExit() throws Exception {
        mainMenuCommand.execute();
        verify(io).output(Constant.MAIN_MENU_TEMPLETE);
    }
}