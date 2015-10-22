package com.alucarweb.devolution;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class DevolutionDAO {

	@Inject
	private EntityManager manager;

	public Devolution findById(int devolutionId) {
		Devolution dev = manager.find(Devolution.class, devolutionId);
		return dev;
	}
	
	public void update(){
		
	}
}
