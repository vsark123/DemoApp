package com.jsp.userloginapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.userloginapp.entity.User;
import com.jsp.userloginapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User login(String usernameOrEmail, String password) {
		return userRepository.loginValidate(usernameOrEmail, usernameOrEmail, password);
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User findByUserNameOrEmail(String usernameOrEmail) {
		return userRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail);
	}

}
