package com.twu.biblioteca.model.status;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;

public class MainMenuCommand implements Command {

    private IOInterface io;

    public MainMenuCommand(IOInterface io) {
        this.io = io;
    }

    private void printMainMenu(){
        io.output(Constant.MAIN_MENU_TEMPLETE);
    }

    @Override
    public void execute() {
        printMainMenu();
    }
}
