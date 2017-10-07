package com.example.demo.api.controller;

import com.example.demo.api.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.PostService;

import java.util.List;

@Controller
public class HomeController {

	@Autowired
	PostService postService;
	
	@GetMapping("/")
	List<PostDto> index(Model model){
		return postService.findLatest5();
	}
}
