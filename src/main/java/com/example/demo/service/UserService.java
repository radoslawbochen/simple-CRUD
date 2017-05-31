package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

	User findByUsername(String username);

	User findByEmail(String email);

	void add(User user);

	void delete(User user);
	
}
