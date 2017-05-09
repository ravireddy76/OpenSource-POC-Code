package com.poc.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.poc.beans.User;


@RestController
public class UserController {
	public List<User> loginUsers = new ArrayList<User>();


	@RequestMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity login(@RequestBody User user) {
		
		System.out.println(">>>> Inside Login method :: "+user.toString());
		
		if(user.getUserId().equalsIgnoreCase("test") && user.getPassword().equalsIgnoreCase("test123")){
			loginUsers.add(user);
			return new ResponseEntity(HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value = "/loginusers", method = RequestMethod.GET, produces = "application/json")
	public List<User> getLoginUsers() {
		System.out.println(">>>> Inside getLoginUsers method Size :: "+loginUsers.size());
		return loginUsers;
	}
}
