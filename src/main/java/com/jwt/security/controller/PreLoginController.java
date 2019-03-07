package com.jwt.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.security.domain.Response;
import com.jwt.security.domain.User;
import com.jwt.security.service.UserService;

@CrossOrigin(origins= {"*"},maxAge=3600)
@RestController
@RequestMapping(value="") 
public class PreLoginController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/registration")
	public ResponseEntity<Response> registration(@RequestBody User user) {
		User dbUser = userService.save(user);
		if (dbUser != null) {
			return new ResponseEntity<Response>(new Response("User is saved successfully"), HttpStatus.OK);
		}
		return null;			
	}
	
	@GetMapping(value = "/getUser")	
	public void getUser() {
		System.out.println("inside getuser");
	}
}
