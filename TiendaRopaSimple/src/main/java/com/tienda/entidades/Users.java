package com.tienda.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4581260781007347521L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "pass")
	private String pass;

	@Column(name = "user_img")
	private String user_img;

	
	
	
	public Users() {
	}

	public Users(Long id, String username, String email, String pass, String user_img) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.user_img = user_img;
	}

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
