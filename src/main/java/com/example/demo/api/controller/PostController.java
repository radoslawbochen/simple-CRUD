package com.example.demo.api.controller;

import javax.validation.Valid;

import com.example.demo.api.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping({"", "/"})
	public List<PostDto> showPosts(@PathVariable("id") Long id){
		return postService.findAll();
	}
	
	@GetMapping("/{id}")
	public PostDto showPost(@PathVariable("id") Long id){
		return postService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable("id") Long id){
		postService.deleteById(id);
	}
	
	@PostMapping({"", "/"})
	public PostDto savePost(@Valid Post post, BindingResult bindingResult){
		return postService.add(post);
	}
	
}
