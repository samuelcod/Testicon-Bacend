package com.testicon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testicon.model.Test;
import com.testicon.repository.TestRepository;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepository testRepository;
	
	@Override
	public List<Test> findAll() {
		// TODO Auto-generated method stub
		return testRepository.findAll() ;
	}

	@Transactional
	@Override
	public Test save(Test test) {
		// TODO Auto-generated method stub
		return testRepository.saveAndFlush(test);
	}

	@Override
	public Test findByTestId(long id) {
		// TODO Auto-generated method stub
		return testRepository.findByTestId(id);
	}

}
