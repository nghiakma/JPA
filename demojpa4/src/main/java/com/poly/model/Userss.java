package com.poly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Userss")
@NamedQuery(name="Userss.findAll", query = "SELECT u FROM Userss u")
public class Userss {
  
	@Id
	@Column(name = "UserId")
	private String userid;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Fullname")
	private String fullname;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Admin")
	private Boolean admin;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	
	
	
}
