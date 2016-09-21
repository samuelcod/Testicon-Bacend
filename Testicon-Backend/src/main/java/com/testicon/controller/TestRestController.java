package com.testicon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testicon.model.Test;
import com.testicon.model.User;
import com.testicon.service.TestService;

@RestController
public class TestRestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/tests", method = RequestMethod.GET)
	public ResponseEntity<List<Test>> listTest() {
		List<Test> tests = testService.findAll();
		
		if(tests.isEmpty()){
			System.out.println("Test list is empty");
			return new ResponseEntity<List<Test>>(HttpStatus.NO_CONTENT);
		}
		return  new ResponseEntity<List<Test>>(tests, HttpStatus.OK);	
	}
	
	//not tested
	/*@RequestMapping(value="/tests", method = RequestMethod.POST)
	public ResponseEntity<Void>  addNewTest(@RequestBody Test test) {	
		testService.save(test);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
	}*/
	
	@RequestMapping(value="/tests/{id}", method = RequestMethod.GET)
	public ResponseEntity<Test> getTestById(@PathVariable("id") long id) {
		Test test = testService.findByTestId(id);
		if (test == null) {   
			   return new ResponseEntity<Test>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Test>(test, HttpStatus.OK);
	} 
}
