package com.alucarweb.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RequestScoped
public class EntityManagerProducer {

	private EntityManager entityManager;

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("alucar");

	@Produces
	public EntityManager getEntityManager() {

		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
}
