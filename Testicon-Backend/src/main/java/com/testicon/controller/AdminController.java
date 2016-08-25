package com.testicon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping(value= "/admin")
	public String helloAdmin(Model model) {
		model.addAttribute("greeting", "Wellcome admin");
		return "adminpage";
	}

}
