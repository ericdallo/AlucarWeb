package com.alucarweb.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.alucarweb.car.Car;

public class CarDao {
	
	@Inject
	private EntityManager manager;
	
	public List<Car> searchAll(){
		List<Car> carros = manager.createQuery("select c from Car as c where available = true").getResultList();
		return carros;
	}
	
	public Car searchById(long id){
		Car car = manager.find(Car.class, id);
		return car;
	}
	
	public void update(Car car){
		manager.getTransaction().begin();
		manager.merge(car);
		manager.getTransaction().commit();
	}
	
	public Long insert(Car car){
		manager.getTransaction().begin();
		manager.persist(car);
		manager.flush();
		manager.getTransaction().commit();
		return car.getId();
	}

	public void delete(Long id){
		
		//manager.remove(manager.contains(car) ? car : manager.merge(car));	
	}
}
