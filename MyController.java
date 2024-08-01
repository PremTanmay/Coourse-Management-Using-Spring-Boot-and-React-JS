package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React frontend


public class MyController {

    @Autowired
    private CourseService courseService;
    
    @GetMapping("/home")
    public String home() {
        return "this is home";
    }
    
    // Get courses
    @GetMapping("/courses")
    public List<Courses> getCourses() {
        return this.courseService.getCourses();
    }
    
    // Get a specific course
    @GetMapping("/courses/{courseId}")
    public Courses getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }
    
    // Add a course
    @PostMapping("/courses")
    public Courses addCourse(@RequestBody Courses course) {
        return this.courseService.addCourse(course);
    }
    
    // Update a course
    @PutMapping("/courses/{courseId}")
    public Courses updateCourse(@RequestBody Courses course) {
       
        return this.courseService.updateCourse(course);
    }
    
    // Delete a course
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
