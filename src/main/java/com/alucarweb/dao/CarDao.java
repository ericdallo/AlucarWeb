package com.alucarweb.dao;

import java.util.List;

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

	public List<Car> searchAll(){
		List<Car> carros = manager.createQuery("select c from Car as c where available = true").getResultList();
		return carros;
	}
}
