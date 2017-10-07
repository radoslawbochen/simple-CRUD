package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostDao;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostDao postDao;
	
	@Override
	public List<Post> findLatest5() {
		List<Post> posts = new ArrayList<>();
		List<Post> allPosts = findAll();
		ListIterator<Post> allPostsItr = allPosts.listIterator(allPosts.size());
				
		for(int i = 0; i < 5; i++){
			if(allPostsItr.hasPrevious()){
				posts.add(allPostsItr.previous());				
			}
		}		
		return posts;
	}

	@Override
	public List<Post> findAll() {
		return postDao.findAll();
	}

	@Override
	public Post findByTitle(String title) {
		Post post = null;
		List<Post> posts = findAll();
		for(Post tempPost : posts){
			if(tempPost.getTitle() == title){
				post = tempPost;
				break;
			}
		}
		return post;
	}
	
	@Override
	public Post findById(Long id) {		
		return postDao.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Post post) {
		// TODO Auto-generated method stub
		
	}
}