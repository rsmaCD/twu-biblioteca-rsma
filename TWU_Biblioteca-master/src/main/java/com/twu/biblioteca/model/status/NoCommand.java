package com.twu.biblioteca.model.status;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;

public class NoCommand implements Command {
    private IOInterface io;

    public NoCommand(IOInterface io) {
        this.io = io;
    }

    private void printErrorMsg() {
        io.output(Constant.ERROR_COMMAND_MSG);
    }

    @Override
    public void execute() {
        printErrorMsg();
    }
}
