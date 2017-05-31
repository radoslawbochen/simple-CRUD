package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Todo;

public interface TodoService {

	Todo findById(Long id);

	void deleteById(Long id);

	List<Todo> findByUsername(String username);

	void save(Todo todo);

}
