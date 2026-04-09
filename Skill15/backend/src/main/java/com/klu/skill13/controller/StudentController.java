package com.klu.skill13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.skill13.entity.Student;
import com.klu.skill13.repository.StudentRepository;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // GET
    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    // POST
    @PostMapping
    public Student add(@RequestBody Student s) {
        return repo.save(s);
    }
}