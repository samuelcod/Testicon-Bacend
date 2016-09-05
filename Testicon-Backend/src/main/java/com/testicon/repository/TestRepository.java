package com.testicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testicon.model.Test;

@Repository("testRepository")
public interface TestRepository extends JpaRepository<Test, Long> {
	Test findByTestId(long id);
}
