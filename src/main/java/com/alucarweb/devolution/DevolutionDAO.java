package com.alucarweb.devolution;

import javax.inject.Inject;
import javax.persistence.EntityManager;

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
}
