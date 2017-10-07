package com.example.demo.service.impl;

import com.example.demo.api.dto.TodoDto;
import com.example.demo.entity.TodoEntity;
import com.example.demo.service.TodoService;
import com.example.demo.service.mapping.TodoMapper;
import com.sun.tools.javac.comp.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.TodoDao;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoDao todoDao;

	@Autowired
	TodoMapper todoMapper;

	@Override
	public TodoDto findById(Long id) {
		TodoDto result = new TodoDto();
		result = todoMapper.entityToDto(todoDao.findById(id));

		return result;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TodoDto save(TodoDto todoDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
