package com.alucarweb.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	@Inject
	private EntityManager entityManager;

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("alucar");

	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return entityManager = factory.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
