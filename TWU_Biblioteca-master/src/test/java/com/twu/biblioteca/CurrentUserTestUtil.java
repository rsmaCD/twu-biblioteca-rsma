package com.twu.biblioteca;

import com.twu.biblioteca.repo.CurrentUser;

public class CurrentUserTestUtil {

    public void clearLogin() {
        CurrentUser.getInstance().clearUser();
    }
}
