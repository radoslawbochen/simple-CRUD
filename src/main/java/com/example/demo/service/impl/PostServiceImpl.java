package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.example.demo.api.dto.PostDto;
import com.example.demo.service.PostService;
import com.example.demo.service.mapping.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PostDao;


@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostDao postDao;

	@Autowired
	PostMapper postMapper;

	@Override
	public List<PostDto> findLatest5() {
		List<PostDto> result = new ArrayList<>();
		List<PostDto> allPostsDtos = findAll();
		ListIterator<PostDto> allPostsItr = allPostsDtos.listIterator();

		for(int i = 0; i < 5; i++){
			if(allPostsItr.hasPrevious()){
				result.add(allPostsItr.previous());
			}
		}		
		return result;
	}

	@Override
	public List<PostDto> findAll() {
		List<PostDto> result = postMapper.entitiesToDtos(postDao.findAll());

		return result;
	}

	@Override
	public PostDto findByTitle(String title) {
		PostDto result = new PostDto();
		List<PostDto> postDtos = findAll();

		for(PostDto postDto : postDtos){
			if(postDto.getTitle() == title){
				result = postDto;
				break;
			}
		}
		return result;
	}
	
	@Override
	public PostDto findById(Long id) {
		PostDto result = postMapper.entityToDto(postDao.findById(id));

		return result;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PostDto add(PostDto postDto) {
		return null;
	}
}