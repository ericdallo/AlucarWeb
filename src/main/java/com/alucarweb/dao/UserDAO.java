package com.alucarweb.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alucarweb.user.User;

public class UserDAO {

	@Inject
	private EntityManager manager;

	public User validate(String name, String password) {
		String hql = "SELECT u FROM User u WHERE u.name = :name AND u.password = :password";

		TypedQuery<User> query = manager.createQuery(hql, User.class);
		query.setParameter("name", name);
		query.setParameter("password", password);
		
		if(!query.getResultList().isEmpty()){
			return query.getSingleResult();
		}
		return null;
	}

}
