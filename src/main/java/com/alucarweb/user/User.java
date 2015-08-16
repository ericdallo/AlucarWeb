package com.alucarweb.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.alucarweb.util.Crypt;

@Entity @Table(name="user")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	@NotEmpty 
	private String name;
	@NotEmpty 
	private String password;
	
	public long getId() {
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
		this.password = password != null ? Crypt.crypt(password) : "";
	}
	
	public String toString() {
		return "\n" + getName() + "\n" + getPassword();
	}
}