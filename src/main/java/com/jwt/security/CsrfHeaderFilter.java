package com.jwt.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

public class CsrfHeaderFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("...CsrfToken.class.getName() :::" + CsrfToken.class.getName()); 
//		CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
	//	CsrfToken csrfToken = new HttpSessionCsrfTokenRepository().loadToken(request);
	    CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
	    String token = null;
		Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
		if(csrfToken != null) {
		token = csrfToken.getToken();
		}
		if (cookie == null || token != null && !token.equals(cookie.getValue())) {
			cookie = new Cookie("XSRF-TOKEN", token);
			cookie.setPath("/");
			response.addCookie(cookie);

		}
		filterChain.doFilter(request, response);
	}

}

	