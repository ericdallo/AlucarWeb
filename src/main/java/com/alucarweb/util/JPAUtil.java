package com.alucarweb.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	public static EntityManager createEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alucar-mysql");
		return factory.createEntityManager();
	}
}
