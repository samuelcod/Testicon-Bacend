package com.testicon.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testicon.model.User;
import com.testicon.service.UserService;

//import com.testicon.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value ="/hello")
	public String sayHello(Model model) {
		model.addAttribute("greeting", "Wellcome user");
		return "hello";
	}
	
	@RequestMapping(value ="/addnewuser")
	public String addNewUser(Model model) {
		if(userService.findByEmail(getFakeUser().getEmail()) != null) {
			model.addAttribute("greeting", "User with the same email exists");
		} else {
			userService.save(getFakeUser());
			model.addAttribute("greeting", "User added");
		}
		return "hello";
	}

	private User getFakeUser() {
		// TODO Auto-generated method stub
		User user = new User();
		
		user.setAddress("malmö gatan");
		user.setCity("malmö");
		user.setCompany("testicon");
		user.setConfirmed(new BigDecimal(1));
		user.setCountry("sweden");
		user.setEmail("teacher@testicon.com");
		user.setFirstName("teacher");
		user.setGender("Male");
		user.setLastName("teacher");
		user.setPassword("password");
		user.setPersNbr("11111111");
		user.setPostalCode("2222222");;
		user.setStateProvince("skåne");
		user.setTeleNbr("333333333333");
		
		return user;
	}
	
	
}
