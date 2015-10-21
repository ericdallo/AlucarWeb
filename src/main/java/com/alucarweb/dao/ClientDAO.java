package com.alucarweb.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alucarweb.car.Car;
import com.alucarweb.car.CarSpecification;
import com.alucarweb.client.Client;

public class ClientDAO {
	
	@Inject
	private EntityManager manager;
	
	public List<Client> findAll() {		
		String jpql = "SELECT c from Client c";
		TypedQuery<Client> query = manager.createQuery(jpql, Client.class);
		
		List<Client> clientsList = query.getResultList();
		
		return clientsList;
	}
	
	public void insert(Client client) {
		manager.persist(client);
		manager.flush();
	}
	
	public Client findById(long id) {
		Client client = manager.find(Client.class, id);
		return client;
	}
		
	public void update(Client client){
		manager.merge(client);
	}
	
	public void delete(Long id) {
		Client clientToRemove = manager.find(Client.class, id);
		manager.remove(clientToRemove);
	}
}
