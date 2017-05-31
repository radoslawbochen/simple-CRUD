package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.PostService;

@Controller
public class HomeController {

	@Autowired
	PostService postService;
	
	@GetMapping("/")
	String index(Model model){		
		model.addAttribute("latest5Posts", postService.findLatest5());
		return "index";
	}
}
