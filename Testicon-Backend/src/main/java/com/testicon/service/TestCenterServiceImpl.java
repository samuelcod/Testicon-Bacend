package com.testicon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testicon.model.TestCenter;
import com.testicon.repository.TestCenterRepository;

@Service
public class TestCenterServiceImpl implements TestCenterService {

	@Autowired
	TestCenterRepository testCenterRepository;
	
	@Override
	public List<TestCenter> findAll() {
		// TODO Auto-generated method stub
		return testCenterRepository.findAll() ;
	}

	@Override
	public TestCenter findByTestCenterId(long id) {
		// TODO Auto-generated method stub
		return testCenterRepository.findByTestCenterId(id);
	}

}
