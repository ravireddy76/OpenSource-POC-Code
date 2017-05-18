package com.poc.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poc.domain.User;
import com.poc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private transient final Logger logger = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserService userService;

	@RequestMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody User user) throws Exception {
		logger.fine("Creating  new user " + user.toString());

		userService.create(user);
		String responseMessage = "User Information Is Created";
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}

	@RequestMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<String> update(@RequestBody User user) throws Exception {
		logger.fine("Updating  existing user " + user.toString());

		userService.update(user);
		String responseMessage = "User Information Is Updated";
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}

	@RequestMapping(value = "/userId/{userId}", produces = APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("userId") String userId) throws Exception {
		logger.fine("Deleting user by user id : " + userId);

		userService.delete(Integer.parseInt(userId));
		String responseMessage = "User Information Is Deleted";
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}

	@RequestMapping(value = "/userId/{userId}", produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) throws Exception {
		logger.fine("Get user by user id : " + userId);

		User searchedUser = userService.getUserById(Integer.parseInt(userId));
		return new ResponseEntity<>(searchedUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/all", produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(@PathVariable("userId") String userId) throws Exception {
		logger.fine("Get all users : ");

		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

}
