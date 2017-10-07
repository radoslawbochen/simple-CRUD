package com.example.demo.api.controller;

import com.example.demo.api.dto.TodoDto;
import com.example.demo.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.TodoService;

import java.util.List;

@Controller
@RequestMapping("/users/{username}/todo")
public class TodoController {

	@Autowired
	TodoService todoService;

	@GetMapping("/{id}")
	public TodoDto todo(
			@PathVariable("username") String username,
			@PathVariable("id") Long id
			){
		return todoService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTodo(
			@PathVariable(value = "id") Long id,
			@PathVariable(value = "username") String username
			){
		todoService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public TodoDto updateTodo(@RequestParam("todoEntity") TodoDto todoDto){
		return todoService.save(todoDto);

	}	

	@PostMapping({"", "/"})
	public TodoDto saveTodo(
			@RequestParam("todoEntity") TodoDto todoDto,
			@PathVariable("username") String username
			){
			return todoService.save(todoDto);
	}
	
}
