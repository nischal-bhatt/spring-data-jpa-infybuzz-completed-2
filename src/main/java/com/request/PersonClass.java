package com.request;

import java.util.List;

import com.entity.Hobby;

public class PersonClass {

	 private long id;
	 private String name;
	 List<Hobby> hobbies;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Hobby> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	@Override
	public String toString() {
		return "PersonClass [id=" + id + ", name=" + name + ", hobbies=" + hobbies + "]";
	}
	 
	 
}
