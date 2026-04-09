package com.klu.skill13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.skill13.entity.User;
import com.klu.skill13.repository.UserRepository;
import com.klu.skill13.util.JwtUtil;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwt;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        // check user from database
        User u = repo.findByUsername(user.getUsername());

        // if correct password
        if (u != null && u.getPassword().equals(user.getPassword())) {

            // generate token
        	return jwt.generateToken(u.getUsername(), u.getRole());
        }

        return "Invalid Login";
    }
}