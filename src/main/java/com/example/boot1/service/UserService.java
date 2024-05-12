package com.example.boot1.service;

import com.example.boot1.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getUsers();

    void removeUser(User user);

    User findUser(Long id);

    void updateUser(User user);
}
