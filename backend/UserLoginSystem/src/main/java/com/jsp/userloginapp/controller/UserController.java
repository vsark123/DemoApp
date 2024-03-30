package com.jsp.userloginapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.userloginapp.entity.User;
import com.jsp.userloginapp.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("signup")
	public ResponseEntity<User> signup(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.ACCEPTED);
	}

	@GetMapping("login")
	public ResponseEntity<User> login(@RequestParam String usernameOrEmail, @RequestParam String password) {
		return new ResponseEntity<User>(userService.login(usernameOrEmail, password), HttpStatus.ACCEPTED);
	}

	@PostMapping("forgotPassword")
	public ResponseEntity<User> forgorPassword(@RequestParam String usernameOrEmail, @RequestParam String newPassword) {
		return new ResponseEntity<User>(userService.forgotPassword(usernameOrEmail, newPassword), HttpStatus.CREATED);
	}

}
