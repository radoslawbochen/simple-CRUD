package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

public class User {
	
	@JsonProperty("id")
	public Long id;
	@JsonProperty("name")
	public String name;
	@JsonProperty("username")
	public String username;
	@JsonProperty("email")
	public String email;
	@JsonProperty("phone")
	public String phone;
	@JsonProperty("website")
	public String website;
		
	public User(Long id, String name, String username, String email, String phone, String website) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.website = website;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
}
