package com.jwt.security.domain;

import java.io.Serializable;

public class UserDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3332183280079765978L;
	private User user;
	private String token;

	public UserDTO(User user2, String token2) {
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
