package com.alucarweb.rent;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.alucarweb.car.Car;

public class RentDao {
	
	@Inject
	private EntityManager manager;
	
	@Inject
	private Rent rental;

	public void rent(Car car) {
		
	}
	
}
