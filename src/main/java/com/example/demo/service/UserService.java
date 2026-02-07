package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User createUser(User user);

    User getUser(Long id);

    User updateUser(Long id,User user);

    void deleteUser(Long id);
}
