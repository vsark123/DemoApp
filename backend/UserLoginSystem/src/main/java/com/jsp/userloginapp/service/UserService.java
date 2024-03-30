package com.jsp.userloginapp.service;


import com.jsp.userloginapp.entity.User;

public interface UserService {

	User login(String usernameOrEmail, String password);

	User saveUser(User user);

	User forgotPassword(String usernameOrEmail, String newPassword);

}
