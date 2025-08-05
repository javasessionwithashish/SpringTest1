package com.virinchi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserClass {
	//Hibernate will help create a table named
	//"UserClass" with an annotation provided to 
	/*the class, the annotation is "@Entity".
	 * 
	 */
	//GeneratedValue = auto_increment
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //primary key, auto_increment
	private String username;
	private String password;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
