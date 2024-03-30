package com.jsp.userloginapp.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.userloginapp.dao.UserDao;
import com.jsp.userloginapp.entity.User;
import com.jsp.userloginapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User login(String usernameOrEmail, String password) {
		return userDao.login(usernameOrEmail, password);
	}

	@Override
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	public User forgotPassword(String usernameOrEmail, String newPassword) {
		User user = userDao.findByUserNameOrEmail(usernameOrEmail);
		user.setPassword(newPassword);
		return userDao.saveUser(user);
	}

}
