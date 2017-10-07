package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class TodoDao {

	public List<TodoEntity> findAll(){
		ArrayList<TodoEntity> allTodoEntities = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        int todoId = 1;
        TodoEntity tempTodoEntity;
        do{
        	try{
        		tempTodoEntity = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/" + todoId, TodoEntity.class);
        	}catch (HttpClientErrorException e){
        		break;
        	}
		allTodoEntities.add(tempTodoEntity);
		todoId++;
        }while (tempTodoEntity != null);
        
       return allTodoEntities;
	}
	
	public TodoEntity findById(Long id){
		RestTemplate restTemplate = new RestTemplate();
        TodoEntity todoEntity;
        try{
        	todoEntity = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/" + id, TodoEntity.class);
        }catch (HttpClientErrorException e){
        	todoEntity = null;
        }
        
       return todoEntity;
	}	
}