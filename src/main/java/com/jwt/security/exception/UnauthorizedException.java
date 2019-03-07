package com.jwt.security.exception;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedException extends RuntimeException {
	
	protected static MessageSourceAccessor  message =  SpringSecurityMessageSource.getAccessor();
	  
	public UnauthorizedException() {
		super(message.getMessage("AbstractAcessDecisionManager.accessDenied","Access  is denied"));
	}
	
	public UnauthorizedException(String  message) {
		super(message);
	}

}
