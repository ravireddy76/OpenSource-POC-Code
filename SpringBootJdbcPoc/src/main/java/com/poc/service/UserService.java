package com.poc.service;

import java.util.List;
import com.poc.dao.UserDao;
import com.poc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void create(User user) throws Exception {
		int insertedRows = userDao.create(user);
		if (insertedRows <= 0) {
			throw new Exception("Unable to insert user information into DB.");
		}
	}

	public void update(User user) throws Exception {
		userDao.update(user);
	}

	public void delete(int userId) throws Exception {
		int deleteStatus = userDao.delete(userId);
		if (deleteStatus <= 0) {
			throw new Exception("Unable to delete user information in DB.");
		}
	}

	public User getUserById(int userId) throws Exception {
		User searchedUser = userDao.findUserById(userId);
		return searchedUser;
	}

	public List<User> getAllUsers() {
		List<User> users = userDao.findAll();
		return users;
	}
}
