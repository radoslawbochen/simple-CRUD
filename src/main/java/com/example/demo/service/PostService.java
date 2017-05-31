package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Post;

public interface PostService {

	List<Post> findLatest5();

	List<Post> findAll();

	Post findById(Long id);

	void deleteById(Long id);

	void add(Post post);

	Post findByTitle(String title);

}
