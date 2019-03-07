package com.jwt.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.security.JwtTokenUtil;
import com.jwt.security.JwtUser;
import com.jwt.security.domain.User;
import com.jwt.security.domain.UserDTO;
import com.jwt.security.exception.UnauthorizedException;

@RestController
public class AuthenticationController {
	
	@Value("${jwt.header}")
	private String tokenHeader;
	
	@Autowired private AuthenticationManager authenticationManager;	
	@Autowired private JwtTokenUtil jwtTokenUtil;

	@PostMapping(value="/login")
	public ResponseEntity<UserDTO> login(@RequestBody User user, HttpServletRequest request , HttpServletResponse response) {
	try {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//System.out.println("matches ::" + encoder.matches("123", user.getPassword()));
		System.out.println("User entered password" + user.getPassword() );
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		final JwtUser userDetails = (JwtUser)authentication.getPrincipal();
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(userDetails);
		response.setHeader("Token", token);
		return new ResponseEntity<UserDTO>(new UserDTO(userDetails.getUser(), token) , HttpStatus.OK);
	}catch(UnauthorizedException ex) {
		ex.printStackTrace();
		throw new UnauthorizedException(ex.getMessage());
	}
	}
	

}
