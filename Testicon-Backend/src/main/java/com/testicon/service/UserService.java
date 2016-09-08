package com.testicon.service;

import java.util.List;

import com.testicon.model.User;

public interface UserService {
	//User save(User user);
	List<User> findAll();
	User findByUserId(long id);
	//long deleteByUserId(long id);
	//boolean exist(User user);
	//User findByEmail(String email);
}
