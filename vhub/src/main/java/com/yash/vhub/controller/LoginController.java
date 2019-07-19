package com.yash.vhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.vhub.domain.User;
import com.yash.vhub.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/login")
	Object login(Authentication auth) {
		try {
			User user = userRepository.findOneByEmail(auth.getName());
			System.out.println("Found user: "+user.getEmail());
			return user;
		} catch (NullPointerException ex) {
			System.out.println("User not found.");
			return ResponseEntity.status(401).body("Unauthorized.");
		}
	}
	
}
