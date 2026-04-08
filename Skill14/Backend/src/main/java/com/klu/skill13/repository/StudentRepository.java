package com.klu.skill13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.skill13.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}