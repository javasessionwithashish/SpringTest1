package com.virinchi.model;

import jakarta.persistence.*;

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
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
