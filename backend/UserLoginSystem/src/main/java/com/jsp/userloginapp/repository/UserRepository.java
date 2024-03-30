package com.jsp.userloginapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jsp.userloginapp.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select u from User u where (u.username=?1 or u.email=?2) and u.password=?3")
	public User loginValidate(String username, String email, String password);

	@Query("select u from User u where u.username=?1 or u.email=?2")
	public User findByUserNameOrEmail(String username, String email);

}
