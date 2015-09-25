package com.alucarweb.user;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class LoggedUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
