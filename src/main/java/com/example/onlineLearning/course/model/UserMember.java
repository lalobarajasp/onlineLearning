package com.example.onlineLearning.course.model;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "user_member")
public class UserMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    private String name;
    private String email;
    //@ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(
            name = "enrollments",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private  List<Course> enrolledCourses;

    public UserMember() {
    }
    public UserMember(Long user_id, String name, String email, List<Course> enrolledCourses) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.enrolledCourses = enrolledCourses;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

}
