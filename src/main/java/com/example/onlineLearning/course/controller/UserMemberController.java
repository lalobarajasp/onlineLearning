package com.example.onlineLearning.course.controller;

import com.example.onlineLearning.course.model.Course;
import com.example.onlineLearning.course.model.UserMember;
import com.example.onlineLearning.course.service.UserMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/member")
public class UserMemberController {
    @Autowired
    private UserMemberService userMemberService;

    @PostMapping(path = "/{userId}/enroll/{courseId}")
    public String enrollCourseController (@PathVariable("userId") Long user_id, @PathVariable("courseId") Long course_id) {
        userMemberService.enrollCourse(user_id, course_id);
        return "You've been enrolled successfully!";
    }

    @PostMapping(path = "/{userId}/unenroll/{courseId}")
    public String unEnrollCourseController (@PathVariable("userId") Long user_id, @PathVariable("courseId") Long course_id) {
        userMemberService.unEnrollCourse(user_id, course_id);
        return "You've been unenrolled successfully!";
    }

    //ADD, UPDATE AND DELETE USER MEMBER
    @PostMapping(path = "/create")
    private ResponseEntity<UserMember> createController(@RequestBody UserMember userMember){
        UserMember temporal = userMemberService.create(userMember);
        try{
            return ResponseEntity.created(new URI("/"+temporal.getUser_id())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/members")
    private ResponseEntity<List<UserMember>> getAllUserMemberController (){
        return ResponseEntity.ok(userMemberService.getAllUserMember());
    }


    @GetMapping (path = "/members/{userId}")
    public UserMember getOnlyUserMemberController (@PathVariable("userId")Long user_id) {
        return userMemberService.getOnlyUserMember(user_id);
    }
    //change to json request
    @PutMapping(path = "/members/{userId}")
    public UserMember updateUserMemberController(@PathVariable("userId") Long user_id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false) List<Course> enrolledCourses) {
        return userMemberService.updateUserMember(user_id, name, email, enrolledCourses);
    }

    @DeleteMapping (path = "/members/{userId}")
    public UserMember deleteUserMemberController(@PathVariable("userId") Long user_id) {
        return userMemberService.deleteUserMember(user_id);
    }





}
