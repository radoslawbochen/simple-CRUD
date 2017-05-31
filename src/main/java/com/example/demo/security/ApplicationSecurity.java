package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
            	.antMatchers("/").permitAll()
	            .antMatchers("/login").permitAll()
	            .antMatchers("/users/**").hasRole("USER")
	            .antMatchers("/manage/**").hasRole("ADMIN");
	}
	
}