package com.twu.biblioteca.repo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserRepoTest {

    private UserRepo userRepo = UserRepo.getInstance();

    @Before
    public void setUp() throws Exception {
        userRepo.initUserRepo();
    }

    @Test
    public void shouldReturnTrueGivenMatchedLibraryNumAndPassword() throws Exception {
        assertNotNull(userRepo.checkLibraryNumAndPasswordMatch("111-1111","111"));
    }

    @Test
    public void shouldReturnFalseGivenMatchedLibraryNumAndPassword() throws Exception {
        assertNull(userRepo.checkLibraryNumAndPasswordMatch("xxx","xxx"));
    }
}