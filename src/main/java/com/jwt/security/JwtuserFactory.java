package com.jwt.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.jwt.security.domain.User;

public class JwtuserFactory {

	public static JwtUser create(User user) {
		// TODO Auto-generated method stub
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), user, user.isEnabled(), maptoGrantedAuthorities(new ArrayList<String>(Arrays.asList("ROLE_" + user.getRole()))));
	}

	private static List<GrantedAuthority> maptoGrantedAuthorities(List<String> authorities) {
		// TODO Auto-generated method stub
		return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
	}

}
