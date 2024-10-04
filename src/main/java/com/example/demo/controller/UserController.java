package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modle.User;
import com.example.demo.service.UserService;
@CrossOrigin(origins = "http://localhost:3004") 
@RestController
@RequestMapping("/api/users")
public class UserController {

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		// Example login logic (replace with actual logic)
		if (user.getUsername().equals("admin") && user.getPassword().equals("password")) {
			Map<String, Object> response = new HashMap<>();
			response.put("userId", 1); // Example user ID
			response.put("message", "Login successful");
			return ResponseEntity.ok(response);
		} else {
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("message", "Invalid credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
		}
	}
}
