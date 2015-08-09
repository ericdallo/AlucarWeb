package com.alucarweb.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alucarweb.user.User;

public class UserDAO {
	
	private EntityManager manager;
	
	@Deprecated //CDI eyes only
	public UserDAO() {
		this(null);
	}
	
	@Inject
	public UserDAO(EntityManager manager) {
		this.manager = manager;
	}

	public boolean validate(User user) {	
		String hql = "SELECT u FROM User u WHERE u.name = :name AND u.password = :password";
		TypedQuery<User> query =  manager.createQuery(hql,User.class);
		query.setParameter("name", user.getName());
		query.setParameter("password", user.getPassword());
		
		return !query.getResultList().isEmpty();
	}

}
