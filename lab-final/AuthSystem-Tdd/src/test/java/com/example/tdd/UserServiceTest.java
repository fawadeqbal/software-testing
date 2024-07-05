package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        IUserRepository userRepository = new FakeRepositoryForTest();
        userService = new UserService(userRepository);
    }

    @Test
    public void testGetUserById_UserExists() {
        FakeRepositoryForTest.usersList = List.of(new User(1, "Fawad"), new User(2, "Alice"));
        User user = userService.getUserById(1);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(1, user.getId());
        Assertions.assertEquals("Fawad", user.getName());
    }

    @Test
    public void testGetUserById_NoUserFound() {
        FakeRepositoryForTest.usersList = List.of(new User(1, "Fawad"), new User(2, "Alice"));
        User user = userService.getUserById(3);
        Assertions.assertNull(user);
    }
}
