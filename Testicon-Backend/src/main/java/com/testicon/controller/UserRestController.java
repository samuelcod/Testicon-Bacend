package com.testicon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testicon.model.User;
import com.testicon.service.UserService;



@RestController
public class UserRestController {

	@Autowired
	private UserService userService; 

	@RequestMapping(value="/users", method = RequestMethod.GET )
	public ResponseEntity<List<User>> listUsers() {
		List<User> users = userService.findAll();
		
		if(users.isEmpty()){
			System.out.println("User list is empty");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}	
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/users/{id}", method = RequestMethod.GET )
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		User user = userService.findByUserId(id);
		System.out.println("User found: "+ user.getFirstName());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	} 
	
	//Not tested
	/*@RequestMapping(value="/users/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> deleteUserById(@PathVariable("id") long id) {
		System.out.println(" deleteUserById()"); 
		if(userService.deleteByUserId(id) != 0) {
			System.out.println("User deleted"); 
		} else {
			System.out.println("User not deleted"); 
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	*/
	
	//Not tested
	/*@RequestMapping(value="/users", method = RequestMethod.POST)
	public ResponseEntity<Void>  addNewUser(@RequestBody User user) {
		System.out.println("addNewUser(): " + user.getEmail());
		if (userService.exist(user)) {
          System.out.println("User with email" + user.getEmail() + " already exist");
          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
		System.out.println("Email: "+user.getEmail());
		System.out.println("Password: "+user.getPassword());
		System.out.println("id: "+user.getUserId());
		user.setConfirmed(new BigDecimal(1));
		//user.setPassword("password");
		//user.setUserId(1002);
		userService.save(user);
  
        return new ResponseEntity<Void>(HttpStatus.CREATED);
	}*/
		
}
 