package com.ravi.poc.cloud.model;


import java.io.Serializable;


public class User implements Serializable {
	private static final long serialVersionUID = -258589840205167822L;

	private String userId;
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", password='" + password + '\'' +
				'}';
	}

}
