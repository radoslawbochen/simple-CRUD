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
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.TodoService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	TodoService todoService;
	@Autowired
	UserService userService;
	
	@GetMapping({"/", ""})
	String user(Model model){
		//if logged in return "/" + username
		model.addAttribute("registrationForm", new User());
		return "userHome";
	}	
	
	@GetMapping("/login")
	String login(Model model){
		
		return "login";
	}
		
	@GetMapping("/{username}")
	String userHome(@PathVariable(value = "username") String username, Model model){
		model.addAttribute("user", userService.findByUsername(username));		
		return "user";
	}
	
	@PostMapping("/register")
	String addUser(@Valid User user, Model model, BindingResult bindingResult){
		User usernameExists = userService.findByUsername(user.getUsername());
		User emailExists = userService.findByEmail(user.getEmail());
		
		if(bindingResult.hasErrors()){
			return "redirect:/users";
		}else if(usernameExists != null){
			bindingResult.rejectValue("username", "error.user",
							"That username is already taken");
		}else if(emailExists != null){
			bindingResult.rejectValue("email", "error.user",
							"User with that e-mail is already registered");
		}
		
		userService.add(user);
		return "/" + user.getUsername();		
	}
	
	@DeleteMapping("/{username}")
	String deleteUser(@PathVariable(value = "username") String username, Model model){
		User user = userService.findByUsername(username);	
		userService.delete(user);
		return "user";
	}
}
