package com.example.onlineLearning.enrollment.controller;

import com.example.onlineLearning.enrollment.model.Enrollment;
import com.example.onlineLearning.enrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping(path = "/enroll")
    private ResponseEntity<Enrollment> enrollCourseController(@RequestBody Enrollment enrollment){
        Enrollment temporal = enrollmentService.enrollCourse(enrollment);
        try{
            return ResponseEntity.created(new URI("/"+temporal.getId())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping(path = "/unenroll/{id}")
    private Enrollment unEnrollController(@PathVariable("id") Long id){
        return enrollmentService.unEnrollCourse(id);
    }


}
