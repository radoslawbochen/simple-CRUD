package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Post;

public class PostDao {

	public List<Post> findAll(){		
		ArrayList<Post> allPosts = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        int postId = 1;
        Post tempPost;        
        do{
        	try{
        		tempPost = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + postId, Post.class);
        	}catch (HttpClientErrorException e){
        		break;
        	}
		allPosts.add(tempPost);
		postId++;
        }while (tempPost != null);
        
       return allPosts;		
	}
	
	public Post findById(Long id){
		RestTemplate restTemplate = new RestTemplate();
		Post post;
        try{
        	post = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/" + id, Post.class);
        }catch (HttpClientErrorException e){
        	post = null;
        }
        
       return post;
	}
	
}
