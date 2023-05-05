package com.example.onlineLearning.user.respository;

import com.example.onlineLearning.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
