package com.jwt.security.domain;

import java.io.Serializable;

public class Response implements Serializable {
   
	public Response(String message) {
		// TODO Auto-generated constructor stub
		super();
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}  

}
