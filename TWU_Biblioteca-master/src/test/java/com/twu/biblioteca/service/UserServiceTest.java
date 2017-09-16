package com.twu.biblioteca.service;

import com.twu.biblioteca.repo.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepo userRepo;
    @InjectMocks
    private UserService userService = new UserService();

    @Test
    public void shouldCallCheckLibraryNumAndPasswordMatch() throws Exception {
        when(userRepo.checkLibraryNumAndPasswordMatch("1","1")).thenReturn(true);
        userService.checkLibraryNumAndPasswordMatch("1","1");
        verify(userRepo).checkLibraryNumAndPasswordMatch("1","1");
    }
}