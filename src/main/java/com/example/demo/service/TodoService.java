package com.example.demo.service;

import com.example.demo.api.dto.TodoDto;

public interface TodoService {

	TodoDto findById(Long id);

	void deleteById(Long id);

	TodoDto save(TodoDto todoDto);

}
