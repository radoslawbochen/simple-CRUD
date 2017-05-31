package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Todo;
import com.example.demo.entity.User;
import com.example.demo.repository.TodoDao;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoDao todoDao;
	@Autowired
	UserService userService;
	
	@Override
	public Todo findById(Long id) {
		return todoDao.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Todo> findByUsername(String username) {
		List<Todo> userTodos = new ArrayList<>();
		List<Todo> todos = todoDao.findAll();
		User user = userService.findByUsername(username);
		for(Todo tempTodo : todos){
			if(tempTodo.getUserId() == user.getId()){
				userTodos.add(tempTodo);
			}
		}
		return userTodos;
	}

	@Override
	public void save(Todo todo) {
		// TODO Auto-generated method stub
		
	}

}
