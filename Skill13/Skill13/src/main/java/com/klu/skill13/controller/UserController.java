package com.klu.skill13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.skill13.entity.User;
import com.klu.skill13.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository repo;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User u = repo.findByUsername(user.getUsername());
        if (u != null && u.getPassword().equals(user.getPassword())) {
            return u;
        }
        return null;
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return repo.findByUsername(username);
    }
}