package com.twu.biblioteca.repo;

import com.twu.biblioteca.model.entity.User;

public class CurrentUser {

    private static final CurrentUser currentUser = new CurrentUser();
    private static User user = null;
    public static CurrentUser getInstance() {
        return currentUser;
    }

    public void setCurrentUser(User user){
        this.user = user;
    }

    public static boolean isCurrentUserLogin(){
        return user != null;
    }
}
