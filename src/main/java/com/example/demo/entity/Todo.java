package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Todo {

	@JsonProperty("id")
	public Long id;
	@JsonProperty("userId")
	public Long userId;
	@JsonProperty("title")
	public String title;
	@JsonProperty("completed")
	public Boolean completed;
	
	public Todo(){	}
	
	public Todo(Long id, Long userId, String title, Boolean completed) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.completed = completed;
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

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}	
}
