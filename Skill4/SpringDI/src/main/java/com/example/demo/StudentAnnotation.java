package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StudentAnnotation {

    @Value("102")
    private int studentId;

    @Value("Indra")
    private String name;

    @Value("Spring")
    private String course;

    @Value("2")
    private int year;

    public void display() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name : " + name);
        System.out.println("Course : " + course);
        System.out.println("Year : " + year);
    }
}