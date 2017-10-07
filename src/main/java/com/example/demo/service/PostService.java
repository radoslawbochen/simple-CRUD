package com.example.demo.service;

import java.util.List;

import com.example.demo.api.dto.PostDto;
import com.example.demo.entity.PostEntity;

public interface PostService {

	List<PostDto> findLatest5();

	List<PostDto> findAll();

	PostDto findById(Long id);

	void deleteById(Long id);

	PostDto add(PostDto postDto);

	PostDto findByTitle(String title);

}
