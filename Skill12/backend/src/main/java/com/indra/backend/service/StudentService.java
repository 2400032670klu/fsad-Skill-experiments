package com.indra.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.backend.model.Student;
import com.indra.backend.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student saveStudent(Student s) {
        return repo.save(s);
    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}