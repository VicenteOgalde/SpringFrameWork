package com.vicoga.form.app.models;


public class User {
	
	private String name;
	
	private String pass;
	
	private String email;
	
	

	public User() {
		
	}
	
	public User(String name, String pass, String email) {
		
		this.name = name;
		this.pass = pass;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
