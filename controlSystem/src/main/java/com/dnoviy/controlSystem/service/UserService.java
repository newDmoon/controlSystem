package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    public List<User> getAllUsers();

    public User deleteUser(User user);
}
