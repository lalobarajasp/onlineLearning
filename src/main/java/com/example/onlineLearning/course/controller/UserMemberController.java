package com.example.onlineLearning.course.controller;

import com.example.onlineLearning.course.model.Course;
import com.example.onlineLearning.course.model.UserMember;
import com.example.onlineLearning.course.service.UserMemberService;
import com.example.onlineLearning.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

//@Controller
//@RequestMapping("/users")
public class UserMemberController {
//    @Autowired
//    private UserMemberService userMemberService;
//
//    @PostMapping("/{userId}/enroll/{courseId}")
//    public String enrollCourse(@PathVariable("userId") Long user_id, @PathVariable("courseId") Long course_id) {
//        userMemberService.enrollCourse(user_id, course_id);
//        return "redirect:/users/{userId}";
//    }
//
//    @PostMapping("/{userId}/unenroll/{courseId}")
//    public String unEnrollCourse(@PathVariable("userId") Long user_id, @PathVariable("courseId") Long course_id) {
//        userMemberService.unEnrollCourse(user_id, course_id);
//        return "redirect:/users/{userId}";
//    }
//
//    //ADD, UPDATE AND DELETE USER MEMBER
//    @PostMapping("/create")
//    private ResponseEntity<UserMember> save(@RequestBody UserMember userMember){
//        UserMember temporal = userMemberService.create(userMember);
//        try{
//            return ResponseEntity.created(new URI("/"+temporal.getUser_id())).body(temporal);
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//    }
//
//    @GetMapping("/users")
//    private ResponseEntity<List<UserMember>> AllUserMember (){
//        return ResponseEntity.ok(userMemberService.getAllUserMember());
//    }
//
//    @GetMapping (path="/user/{userId}")
//    public UserMember getUser(@PathVariable("userId")Long user_id) {
//        return userMemberService.getOnlyUserMember(user_id);
//    }
//
//    @PutMapping(path="user/{userId}")
//    public UserMember updateUserMember(@PathVariable("userId") Long user_id,
//                             @RequestParam(required = false) String name,
//                             @RequestParam(required = false) String email,
//                             @RequestParam(required = false) List<Course> enrolledCourses) {
//        return userMemberService.updateUserMember(user_id, name, email, enrolledCourses);
//    }
//
//    @DeleteMapping (path="user/{userId}")
//    public UserMember deleteUserMember(@PathVariable("userId") Long user_id) {
//        return userMemberService.deleteUserMember(user_id);
//    }




}
