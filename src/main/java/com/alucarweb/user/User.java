package com.alucarweb.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.alucarweb.util.Crypt;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String password;

	@NotEmpty
	@Column(name = "permission")
	@Enumerated(EnumType.STRING)
	private UserPermission userPermission;

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

	public UserPermission getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(UserPermission userPermission) {
		this.userPermission = userPermission;
	}

	public String toString() {
		return "\n" + getName() + "\n" + getPassword();
	}
}