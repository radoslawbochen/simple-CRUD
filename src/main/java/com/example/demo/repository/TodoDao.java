package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Todo;

@Repository
public class TodoDao {

	@Autowired
	UserDao userDao;
	
	public List<Todo> findAll(){
		ArrayList<Todo> allTodos = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        int todoId = 1;
        Todo tempTodo;        
        do{
        	try{
        		tempTodo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/" + todoId, Todo.class);
        	}catch (HttpClientErrorException e){
        		break;
        	}
		allTodos.add(tempTodo);
		todoId++;
        }while (tempTodo != null);
        
       return allTodos;		
	}
	
	public Todo findById(Long id){
		RestTemplate restTemplate = new RestTemplate();
        Todo todo;
        try{
        	todo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/" + id, Todo.class);
        }catch (HttpClientErrorException e){
        	todo = null;
        }
        
       return todo;
	}	
}