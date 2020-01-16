package com.hao.test.ut;

public class UserService {

    public User save(String name) {
        System.out.println("UserService--save--name:" + name);
        User u = new User(name);
        u.setId((long)(Math.random() * 1000) + 2);
        return u;
    }
}
