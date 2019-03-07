package com.jwt.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.jwt.security.controller.PreLoginController;
import com.jwt.security.controller.UserController;

@SpringBootApplication
public class SpringBootJwtAuthApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(SpringBootJwtAuthApplication.class, args);
		/*PreLoginController controller=context.getBean(PreLoginController.class);
		controller.getUser();*/
		System.out.println("Inside main");
	}
	
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedHeader("*");
		config.addAllowedOrigin("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
	
	

}

