package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.springrest.dao.Coursedao;
import com.springrest.springrest.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private Coursedao coursedao;
   
    public CourseServiceImpl() {
    }

    @Override
    public List<Courses> getCourses() {
        return coursedao.findAll();
    }

    @Override
    public Courses getCourse(long courseId) {
        return coursedao.findById(courseId).orElse(null);
    }

    @Override
    public Courses addCourse(Courses course) {
        coursedao.save(course);
        return course;
    }
    
    @Override
    public Courses updateCourse(Courses course) {
        coursedao.save(course);
        return course;
    } 
    
    @Override
    public void deleteCourse(long courseId) {
        Courses entity = coursedao.findById(courseId).orElse(null);
        if (entity != null) {
            coursedao.delete(entity);
        }
    }
}
