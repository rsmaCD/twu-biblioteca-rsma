package com.twu.biblioteca.repo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserRepoTest {

    private UserRepo userRepo = UserRepo.getInstance();

    @Before
    public void setUp() throws Exception {
        userRepo.initUserRepo();
    }

    @Test
    public void shouldReturnTrueGivenMatchedLibraryNumAndPassword() throws Exception {
        assertTrue(userRepo.checkLibraryNumAndPasswordMatch("111-1111","111"));
    }

    @Test
    public void shouldReturnFalseGivenMatchedLibraryNumAndPassword() throws Exception {
        assertFalse(userRepo.checkLibraryNumAndPasswordMatch("xxx","xxx"));
    }
}