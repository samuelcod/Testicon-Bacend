package com.testicon.service;

import java.util.List;

import com.testicon.model.Test;

public interface TestService {
	List<Test> findAll();
	//Test save(Test test);
	Test findByTestId(long id);
}
