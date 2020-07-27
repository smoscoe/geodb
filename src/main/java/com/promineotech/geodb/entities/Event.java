package com.promineotech.geodb.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicUpdate
public class Event {
	
	private Long id;
	private int zone;
	private int vertical;
	private int horizontal;
	private Date date;
	private double size;
	private int depth;
	
	@JsonIgnore
	private Set<Station> stations;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public Set<Station> getStations() {
		return stations;
	}
	public void setStations(Set<Station> stations) {
		this.stations = stations;
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
