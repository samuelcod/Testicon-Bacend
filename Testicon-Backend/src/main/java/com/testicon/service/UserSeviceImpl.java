package com.testicon.service;

import java.util.List;

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
	

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findByUserId(long id) {
		// TODO Auto-generated method stub
		return userRepository.findByUserId(id);
	}

	/*@Override
	public long deleteByUserId(long id) {
		// TODO Auto-generated method stub
		return userRepository.deleteByUserId(id);
	}

	@Override
	public boolean exist(User user) {
		// TODO Auto-generated method stub
		if(userRepository.findByEmail(user.getEmail()) != null) {
			return true;
		} 
		return false;
	}


	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
*/
}
