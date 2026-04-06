package com.indra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.indra.backend.model.Student;
import com.indra.backend.service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Student s) {
        return ResponseEntity.ok(service.saveStudent(s));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}