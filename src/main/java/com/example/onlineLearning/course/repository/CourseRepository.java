package com.example.onlineLearning.course.repository;

import com.example.onlineLearning.course.model.Course;
import com.example.onlineLearning.course.model.UserMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitleContainingIgnoreCase(String title);
    List<Course> findByCategoryContainingIgnoreCase(String category);
    List<Course> findByKeywordsContainingIgnoreCase(String keywords);

}
