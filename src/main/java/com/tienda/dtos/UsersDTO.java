package com.tienda.dtos;

import java.io.Serializable;

public class UsersDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2410368535937091556L;

	private Long id;

	private String username;

	private String email;

	private String pass;

	private String user_img;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

}
