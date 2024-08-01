package com.springrest.springrest.services;

import java.util.List;
import com.springrest.springrest.entities.Courses;

public interface CourseService {
    List<Courses> getCourses();
    Courses getCourse(long courseId);
    Courses addCourse(Courses course);
    Courses updateCourse(Courses course);
    void deleteCourse(long courseId);
}
