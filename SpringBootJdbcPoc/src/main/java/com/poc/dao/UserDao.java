package com.poc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.poc.domain.User;
import com.poc.mapper.UserMapper;

@Repository
public class UserDao {
	private static final String INSERT_SQL_QUERY = "INSERT INTO USERS(name,address,email) values(?,?,?)";
	private static final String UPDATE_SQL_QUERY = "UPDATE USERS SET name=?,address=?,email=? WHERE user_id=?";
	private static final String DELETE_SQL_QUERY = "DELETE FROM USERS WHERE user_id=?";
	private static final String FIND_ALL_USERS_QUERY = "SELECT * FROM USERS";
	private static final String FIND_USER_BY_ID_QUERY = "SELECT * FROM USERS WHERE user_id = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int create(User user) {
		int insertedRows = jdbcTemplate.update(INSERT_SQL_QUERY, user.getName(), user.getAddress(), user.getEmail());
		return insertedRows;
	}

	public void update(User user) {
		jdbcTemplate.update(UPDATE_SQL_QUERY,
				new Object[] { user.getName(), user.getAddress(), user.getEmail(), user.getId() });

	}

	public int delete(int userId) {
		return jdbcTemplate.update(DELETE_SQL_QUERY, new Object[] { userId });
	}

	public User findUserById(int userId) {
		return jdbcTemplate.queryForObject(FIND_USER_BY_ID_QUERY, new Object[] { userId }, new UserMapper());
	}

	public List<User> findAll() {
		return jdbcTemplate.query(FIND_ALL_USERS_QUERY, new UserMapper());
	}

}
