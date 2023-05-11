package com.example.onlineLearning.course.repository;

import com.example.onlineLearning.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
