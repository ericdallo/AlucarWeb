package com.alucarweb.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.alucarweb.car.Car;
import com.alucarweb.client.Client;

public class ClientDAO {
	
	@Inject
	private EntityManager manager;
	
	public void insert(Client client) {
		manager.persist(client);
		manager.flush();
	}
	
	public Client findById(long id) {
		Client client = manager.find(Client.class, id);
		return client;
	}
}
