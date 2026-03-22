package com.indra.student.controller;

import com.indra.student.model.Student;
import com.indra.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    // GET student
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // ADD student
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student s) {
        return service.saveStudent(s);
    }
}