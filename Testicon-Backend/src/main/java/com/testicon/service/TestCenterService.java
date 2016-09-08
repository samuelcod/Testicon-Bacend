package com.testicon.service;

import java.util.List;

import com.testicon.model.TestCenter;

public interface TestCenterService {
	List<TestCenter> findAll();
	TestCenter findByTestCenterId(long id);
}
