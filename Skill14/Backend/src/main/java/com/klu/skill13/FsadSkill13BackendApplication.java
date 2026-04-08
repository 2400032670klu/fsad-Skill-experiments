package com.klu.skill13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.klu.skill13.entity.Student;
import com.klu.skill13.repository.StudentRepository;

@SpringBootApplication
public class FsadSkill13BackendApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(FsadSkill13BackendApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Student s = new Student();
        s.setName("Skill13 Demo");
        repo.save(s);
    }
}