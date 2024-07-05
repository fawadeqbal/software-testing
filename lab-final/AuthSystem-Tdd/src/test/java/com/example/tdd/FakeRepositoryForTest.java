package com.example.tdd;

import java.util.List;

public class FakeRepositoryForTest implements IUserRepository{
    public static List<User> usersList;
    
    @Override
    public List<User> findAllUsers() {
        return usersList;
    }
}
