package com.example.onlineLearning.course.service;

import com.example.onlineLearning.course.model.Course;
import com.example.onlineLearning.course.model.UserMember;
import com.example.onlineLearning.course.repository.CourseRepository;
import com.example.onlineLearning.course.repository.UserMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Course getOnlyCourse(Long course_id) {
        return courseRepository.findById(course_id).orElseThrow(
                () -> new IllegalStateException("The course with id: " + course_id + " doesn't exist.")
        );
    }

    //Update Course
    public Course updateCourse(Long course_id, String title, String category, String keywords, Date startDate, Date endDate, Long durationInWeeks) {
        Course tmpCourse = null;
        if (courseRepository.existsById(course_id)) {
            tmpCourse = courseRepository.findById(course_id).get();
            if (title != null) tmpCourse.setTitle(title);
            if (category != null) tmpCourse.setCategory(category);
            if (keywords != null) tmpCourse.setKeywords(keywords);
            if (startDate != null) tmpCourse.setStartDate(startDate);
            if (endDate != null) tmpCourse.setEndDate(endDate);
            if (durationInWeeks != null) tmpCourse.setDurationInWeeks(durationInWeeks);
            courseRepository.save(tmpCourse);
        } else {
            System.out.println("Update | The course with the id: " + course_id + " doesn't exist.");
        }
        return tmpCourse;
    }

    //Delete Course
    public Course deleteCourse(Long course_id) {
        Course tmpCourse = null;
        if (courseRepository.existsById(course_id)) {
            tmpCourse = courseRepository.findById(course_id).get();
            courseRepository.deleteById(course_id);
        }
        return tmpCourse;
    }

    //Search Course by title, category and keywords
    public List<Course> searchCourses(String search) {
        List<Course> coursesByTitle = courseRepository.findByTitleContainingIgnoreCase(search);
        List<Course> coursesByCategory = courseRepository.findByCategoryContainingIgnoreCase(search);
        List<Course> coursesByKeyword = courseRepository.findByKeywordsContainingIgnoreCase(search);

        List<Course> searchResults = new ArrayList<>();
        searchResults.addAll(coursesByTitle);
        searchResults.addAll(coursesByCategory);
        searchResults.addAll(coursesByKeyword);

        return searchResults;
    }




}
