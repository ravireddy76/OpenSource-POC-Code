package com.ravi.poc.cloud.controller;

import java.util.ArrayList;
import java.util.List;
import com.ravi.poc.cloud.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/allusers", method = RequestMethod.GET, produces = "application/json")
	public List<User> getLoginUsers() {
		List<User> loginUsers = sampleUsers();
		System.out.println(">>>> Inside getLoginUsers method Size :: " + loginUsers.size());

		return loginUsers;
	}

	private List<User> sampleUsers() {
		List<User> users = new ArrayList<>();

		for (int iter = 0; iter < 8; iter++) {
			User user = new User();
			user.setUserId("User-" + (iter + 1));
			user.setPassword("XXXXXXX" + (iter + 1));
			users.add(user);
		}

		return users;
	}

}
