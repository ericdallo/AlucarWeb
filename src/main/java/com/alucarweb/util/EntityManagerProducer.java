package com.alucarweb.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("alucar");
	
	@Produces
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
