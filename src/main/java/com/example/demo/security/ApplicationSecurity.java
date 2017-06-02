package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
	      .inMemoryAuthentication()
	      .withUser("user").password("password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
            	.antMatchers("/", "/posts").permitAll()
	            .antMatchers("/users").hasRole("USER")
	            .antMatchers("/users/login").permitAll()
	            .antMatchers(HttpMethod.POST,"/login").permitAll()
	            .anyRequest().authenticated()
	           .and()
	            .formLogin()
	            .loginPage("/users/login")
	            .loginProcessingUrl("/users/login")
	            .permitAll();
	}	
}