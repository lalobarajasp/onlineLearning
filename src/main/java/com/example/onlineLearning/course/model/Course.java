package com.example.onlineLearning.course.model;
import jakarta.persistence.*;
import java.util.List;
import java.util.*;
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Long durationInWeeks;
//    @ManyToMany(mappedBy =  "enrolledCourses")
//    private List<UserMember> enrolledUsers;


    public Course() {
    }

    public Course(Long id, String name, String description, Date startDate, Date endDate, Long durationInWeeks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationInWeeks = durationInWeeks;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
