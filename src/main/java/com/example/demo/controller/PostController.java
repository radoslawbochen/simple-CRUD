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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping({"", "/"})
	String showPosts(@PathVariable("id") Long id, Model model){
		model.addAttribute("posts", postService.getAll());
		return "post";
	}
	
	@GetMapping("/{id}")
	String showPost(@PathVariable("id") Long id, Model model){
		model.addAttribute("post", postService.getById(id));
		return "post";
	}
	
	@DeleteMapping("/{id}")
	String deletePost(@PathVariable("id") Long id, Model model){
		postService.deleteById(id);
		return "redirect:/posts";
	}
	
	@PostMapping({"", "/"})
	String savePost(@Valid Post post, BindingResult bindingResult, Model model){
		Post titleExists = postService.findByTitle(post.getTitle());
		if(bindingResult.hasErrors()){
			return "redirect:/posts";
		}else if(titleExists != null){
			bindingResult.rejectValue("title", "error.post",
							"There is already post with given title");
		}	
		
		postService.add(post);
		return "/" + post.getTitle();
	}
	
}
