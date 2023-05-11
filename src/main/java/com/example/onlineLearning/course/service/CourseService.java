package com.example.onlineLearning.course.service;

import com.example.onlineLearning.course.model.Course;
import com.example.onlineLearning.course.model.UserMember;
import com.example.onlineLearning.course.repository.CourseRepository;
import com.example.onlineLearning.course.repository.UserMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;


    //Create Course
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    //Retrieve all Courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    //Retrieve Only a Course
    public Course getOnlyCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("The course with id: " + id + " doesn't exist.")
        );
    }

    //Update Course
    public Course updateCourse(Long id, String name, String description, Date startDate, Date endDate, Long durationInWeeks) {
        Course tmpCourse = null;
        if (courseRepository.existsById(id)) {
            tmpCourse = courseRepository.findById(id).get();
            if (name != null) tmpCourse.setName(name);
            if (description != null) tmpCourse.setDescription(description);
            if (startDate != null) tmpCourse.setStartDate(startDate);
            if (endDate != null) tmpCourse.setEndDate(endDate);
            if (durationInWeeks != null) tmpCourse.setDurationInWeeks(durationInWeeks);
            courseRepository.save(tmpCourse);
        } else {
            System.out.println("Update | The course with the id: " + id + " doesn't exist.");
        }
        return tmpCourse;
    }

    //Delete Course
    public Course deleteCourse(Long id) {
        Course tmpCourse = null;
        if (courseRepository.existsById(id)) {
            tmpCourse = courseRepository.findById(id).get();
            courseRepository.deleteById(id);
        }
        return tmpCourse;
    }




}
