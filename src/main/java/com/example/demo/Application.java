package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		UserDao ud = new UserDao();;
		List<User> list = new ArrayList<>();
		list = ud.findAll();
		System.out.println(list.get(1).website);
		
	}	
}
