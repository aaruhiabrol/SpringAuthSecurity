package com.jwt.security.service;

import java.util.List;

import com.jwt.security.domain.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String name);

}
