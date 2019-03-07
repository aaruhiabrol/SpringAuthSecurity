/**
 * 
 */
package com.jwt.security;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.security.domain.User;
import com.jwt.security.repository.UserRepository;

/**
 * @author giggal
 *
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	
	//@Autowired private UserRepository userRepository;
	
	@Autowired UserRepository userRepository;
/*		private static final AtomicLong counter = new AtomicLong();

		private static List<User> users;
		static {
			users = populateDummyUsers();
		}

		private static List<User> populateDummyUsers() {
			List<User> users = new ArrayList<User>();
			return users;
		}
*/

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//User userdb = null;
		User  userdb = userRepository.findByEmailIgnoreCase(username);
		UserDetails details = null;
	/*	for (User user : users) {
			if (user.getEmail() == username) {
				userdb = user;
			}
		}*/
		
		
		if(username == null) {
			throw new UsernameNotFoundException(String.format("No User found with username '%s'.", username));			
		}else {
			details= JwtuserFactory.create(userdb);
			System.out.println("details" + details);
			return details;
		}
	}

}
