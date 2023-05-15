package com.example.onlineLearning.course.repository;

import com.example.onlineLearning.course.model.UserMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMemberRepository extends JpaRepository<UserMember, Long>{
    List<UserMember> findByNameContainingAndEmailContaining(String name, String email);
}