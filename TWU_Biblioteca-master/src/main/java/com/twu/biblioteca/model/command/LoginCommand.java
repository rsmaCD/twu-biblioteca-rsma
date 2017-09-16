package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.service.UserService;

public class LoginCommand implements Command {

    private IOInterface io;

    private UserService userService = new UserService();

    public LoginCommand(IOInterface io) {
        this.io = io;
    }

    @Override
    public void execute() {
        outputLoginNotice();
        login();
    }

    private void login() {
        outputInputLibraryNumNotice();
        String libraryNum = io.getInput();
        outputInputPasswordNotice();
        String password = io.getInput();

        if (userService.checkLibraryNumAndPasswordMatch(libraryNum, password)) {
            outputSuccessNotice();
        } else {
            outputError();
            login();
        }
    }

    private void outputLoginNotice() {
        io.output(Constant.LOGIN_NOTICE);
    }

    private void outputInputLibraryNumNotice() {
        io.output(Constant.INPUT_LIBRARY_NUM_NOTICE);
    }

    private void outputInputPasswordNotice() {
        io.output(Constant.INPUT_PASSWORD_NOTICE);
    }

    private void outputError() {
        io.output(Constant.LOGIN_ERROR);
    }

    private void outputSuccessNotice() {
        io.output(Constant.LOGIN_SUCCESS_NOTICE);
    }
}
