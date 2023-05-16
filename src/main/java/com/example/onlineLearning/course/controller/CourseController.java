package com.example.onlineLearning.course.controller;

import com.example.onlineLearning.course.model.Course;
import com.example.onlineLearning.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(path = "/create")
    private ResponseEntity<Course> createController(@RequestBody Course course){
        Course temporal = courseService.create(course);
        try{
            return ResponseEntity.created(new URI("/"+temporal.getCourse_id())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/courses")
    private ResponseEntity<List<Course>> getAllCoursesController (){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping (path = "/courses/{courseId}")
    private Course getOnlyCourseController (@PathVariable("courseId")Long course_id) {
        return courseService.getOnlyCourse(course_id);
    }

    @PutMapping(path = "/courses/{courseId}")
    public Course updateCourseController(@PathVariable("courseId") Long course_id, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(course_id, updatedCourse);
    }

    @DeleteMapping (path = "/courses/{courseId}")
    public Course deleteCourseController (@PathVariable("courseId") Long course_id) {
        return courseService.deleteCourse(course_id);
    }

    @GetMapping(path = "/search")
    public List<Course> searchCourses(@RequestParam("search") String searchTerm) {
        return courseService.searchCourses(searchTerm);
    }



}
