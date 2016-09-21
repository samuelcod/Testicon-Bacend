
package com.testicon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testicon.model.Admin;
import com.testicon.model.User;
import com.testicon.service.AdminService;

@RestController
public class AdminRestController {

	@Autowired
	private AdminService adminService; 

	@RequestMapping(value="/admins", method = RequestMethod.GET)
	public ResponseEntity<List<Admin>> listAdmins() {
	    List<Admin> admins = adminService.findAll();
	    
	    if(admins.isEmpty()){
	    	System.out.println("Admin list is empty");
			return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/admins/{id}", method = RequestMethod.GET )
	public ResponseEntity<Admin> getAdminById(@PathVariable("id") long id) {
		Admin admin = adminService.findByAdminId(id);
		if (admin == null) {   
			   return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	} 
	
	//not tested
	/*@RequestMapping(value="/admins", method = RequestMethod.POST)
	public ResponseEntity<Void>  addNewAdmin(@RequestBody Admin admin) {
		System.out.println("addNewAdmin(): " + admin.getEmail());
		if (adminService.exist(admin)) {
          System.out.println("Admin with email" + admin.getEmail() + " already exist");
          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }	
		adminService.save(admin);
  
        return new ResponseEntity<Void>(HttpStatus.CREATED);
	}*/
}
