package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import javax.json.Json;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.User;

@Repository
public class UserDao {

	public List<User> findAll(){
		ArrayList<User> allUsers = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        int id = 1;
        User tempUser;
        
        do{
        	try{
                tempUser = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + id, User.class);
        	}catch (HttpClientErrorException e){
        		break;
        	}
		allUsers.add(tempUser);
		id++;
        }while (tempUser != null);
        
       return allUsers;
	}
	
	public User findById(Long id){
		RestTemplate restTemplate = new RestTemplate();
        User user;
        
        try{
        	user = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + id, User.class);
        }catch (HttpClientErrorException e){
        		user = null;
        }
        
       return user;
	}	
}