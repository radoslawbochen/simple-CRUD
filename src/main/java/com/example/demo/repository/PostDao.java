package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.PostEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class PostDao {

	public List<PostEntity> findAll(){
		ArrayList<PostEntity> allPostEntities = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        int postId = 1;
        PostEntity tempPostEntity;
        do{
        	try{
        		tempPostEntity = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + postId, PostEntity.class);
        	}catch (HttpClientErrorException e){
        		break;
        	}
		allPostEntities.add(tempPostEntity);
		postId++;
        }while (tempPostEntity != null);
        
       return allPostEntities;
	}
	
	public PostEntity findById(Long id){
		RestTemplate restTemplate = new RestTemplate();
		PostEntity postEntity;
        try{
        	postEntity = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/" + id, PostEntity.class);
        }catch (HttpClientErrorException e){
        	postEntity = null;
        }
        
       return postEntity;
	}
	
}
