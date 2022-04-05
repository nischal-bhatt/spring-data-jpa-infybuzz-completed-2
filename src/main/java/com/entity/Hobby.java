package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hobby")
public class Hobby {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name="name_of_hobby")
	private String nameOfHobby;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameOfHobby() {
		return nameOfHobby;
	}
	public void setNameOfHobby(String nameOfHobby) {
		this.nameOfHobby = nameOfHobby;
	}
	@Override
	public String toString() {
		return "Hobby [id=" + id + ", nameOfHobby=" + nameOfHobby + ", person=" + person + "]";
	}
	
	
}
