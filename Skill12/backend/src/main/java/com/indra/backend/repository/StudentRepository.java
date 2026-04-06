package com.indra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.indra.backend.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}