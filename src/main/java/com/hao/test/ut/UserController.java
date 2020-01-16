package com.hao.test.ut;

public class UserController {

    private UserService userService = new UserService();

    public User saveUser(String name) {
        return userService.save(name);
    }
}
