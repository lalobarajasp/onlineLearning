package com.example.onlineLearning;

import com.example.onlineLearning.user.model.User;
import com.example.onlineLearning.user.model.UserBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineLearningApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineLearningApplication.class, args);
		User user = new UserBuilder()
				.name("Eduardo")
				.lastName("Barajas")
				.build();
		System.out.println(user.toString());
	}


}
