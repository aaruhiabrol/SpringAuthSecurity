package com.jwt.security.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.jwt.security.domain.User;
import com.jwt.security.repository.UserRepository;
import com.jwt.security.util.PasswordUtil;

@Service
@Transactional //todo
public class UserServiceImpl implements UserService {
	
	@Autowired UserRepository userRepository;
//	private static final AtomicLong counter = new AtomicLong();

//	private static List<User> users;
//	static {
//		users = populateDummyUsers();
//	}

//	private static List<User> populateDummyUsers() {
//		List<User> users = new ArrayList<User>();
//		return users;
//	}
	
	@Override
	public User save(User user) {
		String password = PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
		user.setCreatedDate(new Date());
		// TODO Auto-generated method stub
		//users.add(user);
		userRepository.save(user);
		System.out.println("user created [" + user);

		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();		
	}

	@Override
	public User getUserByEmail(String email) {
//		for (User user : users) {
//			if (user.getEmail() == email) {
//				return user;
//			}
//		}
//		return null;
		return userRepository.findByEmailIgnoreCase(email);
	}

}
