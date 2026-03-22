package com.indra.student.service;

import com.indra.student.model.Student;

public interface StudentService {

    Student saveStudent(Student s);

    Student getStudentById(int id);
}