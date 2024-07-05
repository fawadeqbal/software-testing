package com.example.tdd;

import java.util.List;

/**
 *
 * @author fawad
 */
public class UserService {
    IUserRepository userList;
    
    public UserService(IUserRepository userList) {
        this.userList = userList;
    }
    
    public User getUserById(int id) {
        List<User> users = userList.findAllUsers();
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; 
    }
}
