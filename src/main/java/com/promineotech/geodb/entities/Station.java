package com.promineotech.geodb.entities;

import java.util.Set;

import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicUpdate
public class Station {
	
	private Long id;
	private int zone;
	private int vertical;
	private int horizontal;
	
	@JsonIgnore
	private Set<Member> members;
	
	public int getZone() {
		return zone;
	}
	public void setZone(int zone) {
		this.zone = zone;
	}
	public int getVertical() {
		return vertical;
	}
	public void setVertical(int vertical) {
		this.vertical = vertical;
	}
	public int getHorizontal() {
		return horizontal;
	}
	public void setHorizontal(int horizontal) {
		this.horizontal = horizontal;
	}
	public Set<Member> getMembers() {
		return members;
	}
	public void setMembers(Set<Member> members) {
		this.members = members;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
