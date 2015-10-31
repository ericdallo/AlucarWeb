package com.alucarweb.devolution;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.rent.Rent;
import com.alucarweb.rent.RentDAO;
import com.alucarweb.status.RentStatus;

public class DevolutionDAO {

	@Inject
	private EntityManager manager;
	
	@Inject
	private RentDAO rentDAO;
			

	public Devolution findById(int devolutionId) {
		Devolution dev = manager.find(Devolution.class, devolutionId);
		return dev;
	}
	
	
	public void devolve(Devolution devolution){
		
		//Rent rent = rentDAO.findById(devolution.getRent().getId());
		//rent.setStatus(RentStatus.WAITING_PAYMENT);
		//manager.merge(rent);
		//devolution.getRent().setStatus(RentStatus.WAITING_PAYMENT);
		
		manager.persist(devolution);
	}
}
