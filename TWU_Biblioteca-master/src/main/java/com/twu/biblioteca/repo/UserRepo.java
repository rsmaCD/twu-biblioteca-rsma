package com.twu.biblioteca.repo;

import com.twu.biblioteca.model.entity.User;

import java.util.List;

import static java.util.Arrays.asList;

public class UserRepo {

    private static final UserRepo userRepo = new UserRepo();
    private List<User> users;

    public static UserRepo getInstance() {
        return userRepo;
    }

    private UserRepo() {
    }

    public void initUserRepo() {
        User user1 = new User("user_1", "111@email.com", "1111", "111-1111", "111");
        User user2 = new User("user_2", "222@email.com", "2222", "222-2222", "222");
        User user3 = new User("user_3", "333@email.com", "3333", "333-3333", "333");
        User user4 = new User("user_4", "444@email.com", "4444", "444-4444", "444");

        List<User> users = asList(user1, user2, user3, user4);
        userRepo.setUsers(users);
    }

    public boolean checkLibraryNumAndPasswordMatch(String libraryNum, String password) {

        for (User user:users) {
            if(user.getLibraryNum().equals(libraryNum) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    private void setUsers(List<User> users) {
        this.users = users;
    }
}
