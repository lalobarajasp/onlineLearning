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

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(path = "/create")
    private ResponseEntity<Course> save(@RequestBody Course course){
        Course temporal = courseService.create(course);
        try{
            return ResponseEntity.created(new URI("/"+temporal.getId())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/courses")
    private ResponseEntity<List<Course>> AllCourses (){

        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping (path = "/courses/{courseId}")
    private Course getCourse(@PathVariable("courseId")Long id) {
        return courseService.getOnlyCourse(id);
    }

    @PutMapping(path = "/courses/{courseId}")
    public Course updateCourse(@PathVariable("courseId") Long id,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String description,
                                  @RequestParam(required = false) Date startDate,
                                  @RequestParam(required = false) Date endDate,
                                  @RequestParam(required = false) Long durationInWeeks) {
        return courseService.updateCourse(id, name, description,startDate,endDate,durationInWeeks );
    }

    @DeleteMapping (path = "/courses/{courseId}")
    public Course deleteCourse(@PathVariable("courseId") Long id) {

        return courseService.deleteCourse(id);
    }



}
