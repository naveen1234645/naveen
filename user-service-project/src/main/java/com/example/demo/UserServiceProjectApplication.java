package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication

public class UserServiceProjectApplication implements CommandLineRunner {
	 private UserRepository userRepository;
	 
	 
	 @Autowired
	    public UserServiceProjectApplication(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	public static void main(String[] args) {
		SpringApplication.run(UserServiceProjectApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.save(new User("10","Doe","true"));
	        userRepository.save(new User("15","Public","false"));
	        userRepository.save(new User("13","P","false"));
	}

}
