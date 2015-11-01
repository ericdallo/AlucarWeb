package com.alucarweb.devolution;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alucarweb.car.Car;
import com.alucarweb.rent.Rent;
import com.alucarweb.status.RentStatus;

public class DevolutionDAO {

	@Inject
	private EntityManager manager;

	public Devolution findById(int devolutionId) {
		return manager.find(Devolution.class, devolutionId);
	}
	
	public void returnRent(Devolution devolution){
		manager.persist(devolution);
		Rent rent = manager.find(Rent.class,devolution.getRent().getId());
		rent.setStatus(RentStatus.WAITING_PAYMENT);
		manager.merge(rent);
	}
	
	public Devolution findByRentId(Long rentId){
		String jpql = "SELECT d FROM Devolution d where d.rent.id = :rentId";			

		TypedQuery<Devolution> query = manager.createQuery(jpql, Devolution.class);
		query.setParameter("rentId", rentId);

		Devolution devolution = query.getSingleResult();
		return devolution;
	}
}
