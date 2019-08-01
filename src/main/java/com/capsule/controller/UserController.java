package com.capsule.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capsule.dao.ParentTask;
import com.capsule.dao.Task;
import com.capsule.dao.User;
import com.capsule.serviceimpl.UserServicesimpl;

@RestController
public class UserController {

	@Autowired
	UserServicesimpl userServiceimpl;

	@CrossOrigin(origins = { "http://localhost:4200" })
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		if(user.getFirstname().equalsIgnoreCase("") && user.getLastname().equalsIgnoreCase("") && 
				user.getEmployee() == 0) {
			
			System.out.println(" Error in Request body. ");
			
		}else {
			user.setProjectid(4);;
			user.setTask(5);
			return ResponseEntity.ok(userServiceimpl.addUser(user));
		}
		
		return ResponseEntity.ok(" Not Working. ");
		
	}

	@RequestMapping(value = "/getallUsers", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllUsers() {

		return ResponseEntity.ok(userServiceimpl.getAllUsers());
		// return new ResponseEntity<>(taskRepo.values(), HttpStatus.OK);
	}

	@CrossOrigin(origins = { "http://localhost:4200" })
	@RequestMapping(value = "/deleteUser/{employee}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable("employee") String employee) {
		int empid = Integer.parseInt(employee);
		userServiceimpl.deleteUser(empid);
		return ResponseEntity.ok(" Deleted ");
	}

	@CrossOrigin(origins = { "http://localhost:4200" })
	@RequestMapping(value = "/updateusers", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@RequestBody User user) {

		userServiceimpl.updateUser(user);
		return ResponseEntity.ok(" Updated ");
	}

}
