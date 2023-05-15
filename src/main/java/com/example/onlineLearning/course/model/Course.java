package com.example.onlineLearning.course.model;
import jakarta.persistence.*;
import java.util.List;
import java.util.*;
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long course_id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Long durationInWeeks;

    @ManyToMany(mappedBy =  "enrolledCourses")
    private List<UserMember> enrolledUsers;


    public Course() {
    }

    public Course(Long course_id, String name, String description, Date startDate, Date endDate, Long durationInWeeks, List<UserMember> enrolledUsers) {
        this.course_id = course_id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationInWeeks = durationInWeeks;
        this.enrolledUsers = enrolledUsers;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(Long durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public List<UserMember> getEnrolledUsers() {
        return enrolledUsers;
    }

    public void setEnrolledUsers(List<UserMember> enrolledUsers) {
        this.enrolledUsers = enrolledUsers;
    }
}
