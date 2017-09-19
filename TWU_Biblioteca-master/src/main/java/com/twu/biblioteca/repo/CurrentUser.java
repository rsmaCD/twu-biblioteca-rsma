package com.twu.biblioteca.repo;

import com.twu.biblioteca.model.entity.User;

public class CurrentUser {

    private static final CurrentUser currentUser = new CurrentUser();
    private Principal principal = null;

    public static CurrentUser getInstance() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        Principal principal = new Principal();
        principal.email = user.getEmail();
        principal.name = user.getName();
        principal.phoneNum = user.getPhoneNum();
        this.principal = principal;
    }

    private CurrentUser(){}

    public void clearUser(){
        principal = null;
    }

    public Principal getCurrentUser() {
        return principal;
    }

    public boolean isCurrentUserLogin() {
        return principal != null;
    }

    public class Principal{
        private String name;
        private String email;
        private String phoneNum;

        @Override
        public String toString() {
            return "  " + name +
                    "  " + email +
                    "  " + phoneNum + "\n";
        }
    }
}
