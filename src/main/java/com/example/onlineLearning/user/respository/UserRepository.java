package com.example.onlineLearning.user.respository;

import com.example.onlineLearning.user.model.User;
import com.example.onlineLearning.user.model.UserBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserBuilder,Long> {
}
