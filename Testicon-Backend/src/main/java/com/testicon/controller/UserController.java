package com.testicon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testicon.model.User;
//import com.testicon.service.UserService;


@Controller
public class UserController {
	
	//@Autowired
	//private UserService userService; 
	
	@RequestMapping(value ="/hello")
	public String sayHello(Model model) {
		model.addAttribute("greeting", "Wellcome user");
		//String firstname = userService.findByEmail("jdixon5f@dell.com").getFirstName();
		//System.out.println("User: " + firstname);
		return "hello";
	}
	
}
