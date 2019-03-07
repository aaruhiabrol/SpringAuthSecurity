package com.jwt.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwt.security.domain.User;

public class JwtUser  implements UserDetails {
	
	private final Long id;
	private final String username;
	private final String password;
	private final User user;
	private final boolean enabled;
	private final Collection <? extends GrantedAuthority > authorities;
	
	
	
	public JwtUser(Long id, String username, String password, User user, boolean enabled,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.user = user;
		this.enabled = enabled;
		this.authorities = authorities;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
	@JsonIgnore
	public Long getId() {
		return id;
	}
	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "JwtUser [id=" + id + ", username=" + username + ", password=" + password + ", user=" + user
				+ ", enabled=" + enabled + ", authorities=" + authorities + "]";
	}
}
