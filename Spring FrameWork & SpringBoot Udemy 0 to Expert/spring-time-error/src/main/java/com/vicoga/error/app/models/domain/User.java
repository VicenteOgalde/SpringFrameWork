package com.vicoga.error.app.models.domain;

import java.util.Objects;

public class User {

	private Integer id;
	private String name;
	private String surname;
	
	
	public User() {
	
	}
	public User(Integer id, String name, String surname) {
		
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String toString() {
		return "User [getId()=" + getId() + ", getName()=" + getName() + ", getSurname()=" + getSurname() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
