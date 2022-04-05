package com.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateStudentRequest {

	@JsonProperty("first_name")
	@NotBlank(message = "first name is required")
	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
//to log the object must have to string -- lol
	@Override
	public String toString() {
		return "CreateStudentRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", street=" + street + ", city=" + city + "]";
	}

}
