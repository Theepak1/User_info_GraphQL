package com.capg.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.user.bean.User;
import com.capg.user.mapstruct.dto.UserDTO;
import com.capg.user.service.UserServiceImpl;

import graphql.ExecutionResult;

@RestController
@CrossOrigin
@RequestMapping("/uis")
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody User user)
	{
		UserDTO userDTO = service.addUser(user);
		return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> result = service.getAllUsers();
		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}
	
	 @PostMapping("/getAllUsersGraphql")
	    public ResponseEntity<Object> getAllUsers(@RequestBody String query) {
	        ExecutionResult execute = service.getGraphQL().execute(query);

	        return new ResponseEntity<>(execute, HttpStatus.OK);
	   }
	 
	 @DeleteMapping("/deleteUser/{id}")
	 public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		 	service.deleteUser(id);
			return new ResponseEntity(HttpStatus.OK);	
		}
	 
	 @PutMapping("/updateUser")
		public ResponseEntity<UserDTO> updateUser(@RequestBody User user) {
		 UserDTO userDTO = service.updateUser(user);
			return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
		}

}
