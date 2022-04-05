package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="personzzz")
public class Person {
     @Id
     @GeneratedValue
     private Long id;
     
     @Column(name="name")
     private String name;

     @OneToMany(mappedBy="person",cascade = {CascadeType.PERSIST})
     
     List<Hobby> hobbies;
     
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

	public List<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", hobbies=" + hobbies + "]";
	}
     
     
}
