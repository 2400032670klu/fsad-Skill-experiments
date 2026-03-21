package com.indra.course.service;

import com.indra.course.model.Course;
import com.indra.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    // CREATE
    public Course addCourse(Course course) {
        return repo.save(course);
    }

    // READ ALL
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    // READ ONE
    public Optional<Course> getCourseById(Long id) {
        return repo.findById(id);
    }

    // UPDATE
    public Course updateCourse(Long id, Course newData) {
        Optional<Course> optional = repo.findById(id);

        if (optional.isPresent()) {
            Course c = optional.get();
            c.setTitle(newData.getTitle());
            c.setDuration(newData.getDuration());
            c.setFee(newData.getFee());
            return repo.save(c);
        }
        return null;
    }

    // DELETE
    public boolean deleteCourse(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    // SEARCH
    public List<Course> searchByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }
}