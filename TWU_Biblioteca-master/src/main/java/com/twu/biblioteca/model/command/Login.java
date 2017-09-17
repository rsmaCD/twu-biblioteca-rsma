package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.model.entity.User;
import com.twu.biblioteca.repo.CurrentUser;
import com.twu.biblioteca.service.UserService;

public class Login {

    private IOInterface io;

    private UserService userService = new UserService();

    public Login(IOInterface io) {
        this.io = io;
    }

    public void execute() {
        io.output(Constant.LOGIN_NOTICE);
        login();
    }

    private void login() {
        io.output(Constant.INPUT_LIBRARY_NUM_NOTICE);
        String libraryNum = io.getInput();
        io.output(Constant.INPUT_PASSWORD_NOTICE);
        String password = io.getInput();

        User user = userService.checkLibraryNumAndPasswordMatch(libraryNum, password);
        if (user != null) {
            io.output(Constant.LOGIN_SUCCESS_NOTICE);
            CurrentUser.getInstance().setCurrentUser(user);
        } else {
            io.output(Constant.LOGIN_ERROR);
            login();
        }
    }
}
