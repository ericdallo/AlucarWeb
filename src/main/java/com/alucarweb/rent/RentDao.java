package com.alucarweb.rent;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alucarweb.car.Car;
import com.alucarweb.client.Client;
import com.alucarweb.devolution.Devolution;

public class RentDao {

	@Inject
	private EntityManager manager;

	public void locate(Rent rent, Client client, Car car, Devolution devolution) {
		rent.setCar(car);
		rent.setClient(client);

		rent.setDevolution(devolution);
		manager.persist(rent);
	}

	public List<Rent> findAll() {
		String jpql = "SELECT r FROM Rent r";

		TypedQuery<Rent> rentsQuery = manager.createQuery(jpql, Rent.class);
		List<Rent> rents = rentsQuery.getResultList();
		
		return rents;

	}

	public Rent findById(Long rentId) {
		return manager.find(Rent.class, rentId);
	}

}
