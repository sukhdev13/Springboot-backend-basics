package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(Long id, User user) {
        User user1=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        return userRepository.save(user1);
    }

    @Override
    public void deleteUser(Long id) {
//        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException());
        if(!userRepository.existsById(id)){
            throw new RuntimeException("user not found");
        }
        userRepository.deleteById(id);
    }
}
