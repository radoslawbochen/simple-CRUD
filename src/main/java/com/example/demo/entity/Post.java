package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
	
	@JsonProperty("id")
	public Long id;
	@JsonProperty("userId")
	public Long userId;
	@JsonProperty("title")
	public String title;
	@JsonProperty("body")
	public String body;
		
	public Post(Long id, Long userId, String title, String body) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}	
	
}
