package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User findByUsername(String username) {
		User user = new User();
		List<User> users = userDao.findAll();
		for(User tempUser : users){
			if (tempUser.getUsername() == username){
				user = tempUser;
				break;
			}
		}
		return user;
	}

	@Override
	public User findByEmail(String email) {
		User user = new User();
		List<User> users = userDao.findAll();
		for(User tempUser : users){
			if(tempUser.getEmail() == email){
				user = tempUser;
				break;
			}
		}
		return user;
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

}