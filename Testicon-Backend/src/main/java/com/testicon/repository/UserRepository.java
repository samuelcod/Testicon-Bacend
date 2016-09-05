package com.testicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testicon.model.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	User findByUserId(long id);
	long deleteByUserId(Long id);
}
