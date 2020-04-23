package com.osk.SpringTest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {
	private Integer id;
	private String name;
	private String password;

	public User() {

	}

	public User(Integer id, String name,  String password) {
		
		this.id = id;
		this.name = name;
		
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
