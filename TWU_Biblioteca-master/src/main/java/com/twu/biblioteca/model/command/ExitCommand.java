package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;

public class ExitCommand implements Command {

    private IOInterface io;

    public ExitCommand(IOInterface io) {
        this.io = io;
    }

    private void exit(){
        io.exit();
    }

    @Override
    public void execute() {
        exit();
    }
}
