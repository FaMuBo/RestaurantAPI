package com.exampleFinartz.demo.ServiceTest;


import com.exampleFinartz.demo.entity.User;
import com.exampleFinartz.demo.enums.Role;
import com.exampleFinartz.demo.repositories.UserRepository;
import com.exampleFinartz.demo.services.UserService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private static final Role InitStatus = Role.SELLER;
    private static final Role NewStatus = Role.ADMIN;
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    public void ReturnAllUser() {
        User user1 = User.builder().id(1l).role(Role.SELLER).build();
        User user2 = User.builder().id(2l).role(Role.ADMIN).build();
        List<User> commentList = Arrays.asList(user1, user2);
        Mockito.when(userRepository.findAll()).thenReturn(commentList);
        List<User> fetchedList = userService.getAll();
        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void ReturnUserById() {
        User user = User.builder().role(Role.SELLER).build();
        Mockito.when(userRepository.getById(1L)).thenReturn(user);
        User fetchedUser = userService.getById(1L);
        assertEquals(user.getId(), fetchedUser.getId());
    }

    @Test
    public void ReturnSavedUser() {
        User user = User.builder().role(Role.ADMIN).build();
        Mockito.doReturn(user).when(userRepository).save(user);
        User returnedUser = userService.create(user);
        assertEquals(user.getRole(), returnedUser.getRole());
    }

    @Test
    public void ReturnUpdatedUser() {
        User existUser = User.builder().id(1L).role(InitStatus).build();
        User newUser = User.builder().id(1L).role(NewStatus).build();

        Mockito.when(userRepository.getById(1L)).thenReturn(existUser);
        Mockito.when(userRepository.save(newUser)).thenReturn(newUser);

        User updatedUser = userService.update(newUser);

        Assertions.assertEquals(existUser.getRole(), InitStatus);
        Assertions.assertNotEquals(existUser.getRole(), NewStatus);
    }
}

