package com.testicon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testicon.model.Provider;
import com.testicon.service.ProviderService;

@RestController
public class ProviderRestController {
	
	@Autowired
	ProviderService providerService;
	
	@RequestMapping(value = "/providers", method = RequestMethod.GET)
	public ResponseEntity<List<Provider>> ProvidersList() {
		List<Provider> bookings = providerService.findAll();
	    
	    if(bookings.isEmpty()){
	    	System.out.println("Provider list is empty");
			return new ResponseEntity<List<Provider>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Provider>>(bookings, HttpStatus.OK);
	}

}

