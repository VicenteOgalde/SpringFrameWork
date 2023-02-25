package com.vicoga.form.app.models;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.vicoga.form.app.validation.RegexIdentifier;
import com.vicoga.form.app.validation.Required;

public class User {
	@RegexIdentifier
	private String identifier;
	@Size(min=3,max=8)
	@NotEmpty(message = "the name cant be empty")
	private String name;
	@Required
	private String pass;
	@Email
	@NotEmpty
	private String email;
	@NotNull
	@Min(18)
	@Max(99)
	private Integer age;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateB;
	
	

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

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDateB() {
		return dateB;
	}

	public void setDateB(Date date) {
		this.dateB = date;
	}
	
	

}
