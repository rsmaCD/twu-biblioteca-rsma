package com.twu.biblioteca.service;

import com.twu.biblioteca.model.entity.User;
import com.twu.biblioteca.repo.UserRepo;

public class UserService {

    private UserRepo userRepo = UserRepo.getInstance();

    public User checkLibraryNumAndPasswordMatch(String libraryNum, String password) {
        return userRepo.checkLibraryNumAndPasswordMatch(libraryNum, password);
    }
}
