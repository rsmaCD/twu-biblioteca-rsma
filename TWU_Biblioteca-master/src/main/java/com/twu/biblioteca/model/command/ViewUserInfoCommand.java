package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.repo.CurrentUser;
import com.twu.biblioteca.service.UserService;

public class ViewUserInfoCommand implements Command{

    private IOInterface io;

    public ViewUserInfoCommand(IOInterface io) {
        this.io = io;
    }

    private UserService userService = new UserService();

    @Override
    public void execute() {
        login();
        outputUserInfo();
    }

    private void outputUserInfo() {
        CurrentUser.Principal currentUser = CurrentUser.getInstance().getCurrentUser();
        io.output(currentUser.toString());
    }

    private void login() {
        if(!CurrentUser.getInstance().isCurrentUserLogin()){
            Login login = new Login(io);
            login.execute();
        }
    }
}
