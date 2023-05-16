package com.example.onlineLearning.course.service;

import com.example.onlineLearning.course.model.Course;
import com.example.onlineLearning.course.model.UserMember;
import com.example.onlineLearning.course.repository.CourseRepository;
import com.example.onlineLearning.course.repository.UserMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMemberService {
    @Autowired
    private UserMemberRepository userMemberRepository;
    @Autowired
    private CourseRepository courseRepository;

    //Enroll course
    public UserMember enrollCourse(Long user_id, Long course_id) {
        UserMember user = userMemberRepository.findById(user_id).orElse(null);
        Course course = courseRepository.findById(course_id).orElse(null);

        if (user != null && course != null) {
            List<Course> enrolledCourses = user.getEnrolledCourses();
            enrolledCourses.add(course);
            user.setEnrolledCourses(enrolledCourses);
            return userMemberRepository.save(user);
        }
        return user;
    }

    //Unenroll course
    public UserMember unEnrollCourse(Long user_id, Long course_id) {
        UserMember user = userMemberRepository.findById(user_id).orElse(null);
        Course course = courseRepository.findById(course_id).orElse(null);

        if (user != null && course != null) {
            List<Course> enrolledCourses = user.getEnrolledCourses();
            enrolledCourses.remove(course);
            user.setEnrolledCourses(enrolledCourses);
            return userMemberRepository.save(user);
        }

        return user;
    }

    //Create User
    public UserMember create(UserMember userMember) {
        return userMemberRepository.save(userMember);
    }

    //Retrieve all Users
    public List<UserMember> getAllUserMember() {
        return userMemberRepository.findAll();
    }


    //Retrieve Only a User
    public UserMember getOnlyUserMember(Long user_id) {
        return userMemberRepository.findById(user_id).orElseThrow(
                () -> new IllegalStateException("The User Member with id: " + user_id + " doesn't exist.")
        );
    }

    //Update User
    public UserMember updateUserMember(Long user_id, String name, String email, List<Course> enrolledCourses) {
        UserMember tmpUserM = null;
        if (userMemberRepository.existsById(user_id)) {
            tmpUserM = userMemberRepository.findById(user_id).get();
            if (name != null) tmpUserM.setName(name);
            if (email != null) tmpUserM.setEmail(email);
            if (enrolledCourses != null) tmpUserM.setEnrolledCourses(enrolledCourses);
            userMemberRepository.save(tmpUserM);
        } else {
            System.out.println("Update | The User Member with the id: " + user_id + " doesn't exist.");
        }
        return tmpUserM;
    }

    //Delete User
    public UserMember deleteUserMember(Long user_id) {
        UserMember tmpUserM = null;
        if (userMemberRepository.existsById(user_id)) {
            tmpUserM = userMemberRepository.findById(user_id).get();
            userMemberRepository.deleteById(user_id);
        }
        return tmpUserM;
    }


}
