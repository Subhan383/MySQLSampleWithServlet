package com.org.mysqlservlet.entity;

public class User {
	
	private int User_id;
	private String username;
	private String user_password;
	public User(int user_id, String username, String user_password) {
		super();
		User_id = user_id;
		this.username = username;
		this.user_password = user_password;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	
	

}
