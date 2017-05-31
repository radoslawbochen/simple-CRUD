package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Todo;
import com.example.demo.entity.User;
import com.example.demo.service.TodoService;

@Controller
@RequestMapping("/users/{username}/todo")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("")
	String todos(@PathVariable("username") String username, Model model){
		model.addAttribute(todoService.findByUsername(username));
		return "todos";
	}
	
	@GetMapping("/{id}")
	String todo(
			@PathVariable("username") String username,
			@PathVariable("id") Long id,
			Model model
			){
		model.addAttribute(todoService.findById(id));
		return "todo";
	}
	
	@DeleteMapping("/{id}")
	String deleteTodo(
			@PathVariable(value = "id") Long id,
			@PathVariable(value = "username") String username
			){
		todoService.deleteById(id);
		return "redirect:/users/{username}/todo";
	}
	
	@PutMapping("/{id}")
	String updateTodo(@RequestParam("todo") Todo todo){
		todoService.save(todo);
		return "todo";
	}	

	@PostMapping({"", "/"})
	String saveTodo(@Valid Todo todo, BindingResult bindingResult, Model model){
		Todo titleExists = todoService.findByTitle(todo.getTitle());
		if(bindingResult.hasErrors()){
			return "redirect:/users";
		}else if(titleExists != null){
			bindingResult.rejectValue("title", "error.post",
							"That username is already taken");
		}	
		
		todoService.add(todo);
		return "/" + todo.getId();
	}
	
}
