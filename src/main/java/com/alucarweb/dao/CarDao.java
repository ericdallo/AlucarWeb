package com.alucarweb.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.alucarweb.car.Car;

public class CarDao {
	
	@Inject
	private EntityManager manager;
	
	public Car searchById(long id){
		manager.getTransaction().begin();
		Car car = manager.find(Car.class, id);
		
		manager.getTransaction().commit();
		
		return car;	
	}
}
