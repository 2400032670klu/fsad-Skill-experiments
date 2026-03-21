package com.example.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 101;
    private String name = "Indra";
    private String gender = "Male";

    @Autowired
    private Certification certification;

    public void display() {
        System.out.println("Student ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Gender : " + gender);

        System.out.println("\n--- Certification Details ---");
        certification.display();
    }
}