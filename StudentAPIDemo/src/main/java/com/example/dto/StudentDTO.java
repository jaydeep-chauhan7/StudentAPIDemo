package com.example.dto;

import java.time.LocalDate;

//This is class for Mapping Object to database
public class StudentDTO {
	private int id;
	private String name;
	private LocalDate dob;
	private String email;
	private String country;
	
	
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", dob=" + dob + ", email=" + email + ", country=" + country
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
