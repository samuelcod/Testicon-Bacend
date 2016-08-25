/*package com.testicon.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testicon.model.User;
import com.testicon.repository.UserRepository;




@Service("userService")
public class UserSeviceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.saveAndFlush(user);
	}
	
	//User user = userRepository.findByEmail("jdixon5f@dell.com");
	
	@Transactional
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
		//return User user = userRepository.findByEmail("jdixon5f@dell.com");
	}

}*/
