package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Person;
import com.dnoviy.controlSystem.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User deleteUser(Long id);

    User getOneUser(Long id);

    User updatePersonInfo(User user);

    Person getPersonDetails(Long id);
}
