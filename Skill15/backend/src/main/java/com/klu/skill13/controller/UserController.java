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

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return repo.findByUsername(username);
    }
    @GetMapping("/admin/add")
    public String adminAdd() {
        return "Admin Access Granted";
    }

    @GetMapping("/employee/profile")
    public String employeeProfile() {
        return "Employee Profile Data";
    }
}