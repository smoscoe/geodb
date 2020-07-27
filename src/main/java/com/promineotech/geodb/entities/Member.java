package com.promineotech.geodb.entities;

import javax.persistence.Entity;

import com.promineotech.geodb.util.DegreeLevel;
import com.promineotech.geodb.util.Title;

@Entity
public class Member {
	
	private Long id;
	private String firstName;
	private String lastName;
	private Title title;
	private DegreeLevel education;
	
	
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
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public DegreeLevel getEducation() {
		return education;
	}
	public void setEducation(DegreeLevel education) {
		this.education = education;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
