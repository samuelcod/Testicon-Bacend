package com.testicon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testicon.model.TestCenter;
import com.testicon.model.User;
import com.testicon.service.TestCenterService;

@RestController
public class TestCenterRestController {
	
	@Autowired
	TestCenterService testCenterService;
	
	@RequestMapping(value = "/testcenters", method = RequestMethod.GET)
	public ResponseEntity<List<TestCenter>> listTestCenters() {
		List<TestCenter> testcenters = testCenterService.findAll();
		
		if(testcenters.isEmpty()){
			System.out.println("Test center list is empty");
			return new ResponseEntity<List<TestCenter>>(HttpStatus.NO_CONTENT);
		}
		return  new ResponseEntity<List<TestCenter>>(testcenters, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/testcenters/{id}", method = RequestMethod.GET )
	public ResponseEntity<TestCenter> getTestCenterById(@PathVariable("id") long id) {
		TestCenter testcenter = testCenterService.findByTestCenterId(id);
		//System.out.println("User found: "+ testcenter.getFirstName());
		if (testcenter == null) {   
			   return new ResponseEntity<TestCenter>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TestCenter>(testcenter, HttpStatus.OK);
	} 
}
