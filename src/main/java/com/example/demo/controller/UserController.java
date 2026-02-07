package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getUsers();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@Valid @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        userService.deleteUser(id);
        return "User deleted from DB";
    }
}
