package com.app.models;

public class Smuggler {
	private String name;
	private String lastname;
	private int id;
	
	public Smuggler(){
		
	}
	public Smuggler(int id, String name, String lastname) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
