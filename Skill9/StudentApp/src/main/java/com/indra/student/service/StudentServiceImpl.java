package com.indra.student.service;

import com.indra.student.exception.InvalidInputException;
import com.indra.student.exception.StudentNotFoundException;
import com.indra.student.model.Student;
import com.indra.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repo;

    @Override
    public Student saveStudent(Student s) {
        return repo.save(s);
    }

    @Override
    public Student getStudentById(int id) {

        if (id <= 0) {
            throw new InvalidInputException("Invalid Student ID");
        }

        return repo.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id " + id));
    }
}