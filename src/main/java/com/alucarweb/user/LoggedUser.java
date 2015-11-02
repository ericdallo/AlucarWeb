package com.alucarweb.user;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.alucarweb.agency.Agency;

@Named
@SessionScoped
public class LoggedUser implements Serializable {

	private static final long serialVersionUID = 2L;

	private User user;
	private Agency actualAgency;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isSupervisor() {
		return user.getUserPermission() == UserPermission.SUPERVISOR;
	}

	public void setActualAgency(Agency actualAgency) {
		this.actualAgency = actualAgency;
	}
	public Agency getAgency(){
		return this.actualAgency;
	}
}
