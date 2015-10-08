package com.alucarweb.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alucarweb.car.Car;
import com.alucarweb.car.CarSpecification;
import com.alucarweb.car.state.StatesBr;

public class CarDao {
	
	@Inject
	private EntityManager manager;
	
	public List<Car> findAll(){
		List<Car> carros = manager.createQuery("select c from Car as c where available = true").getResultList();
		return carros;
	}
	
	public Car findById(long id){
		Car car = manager.find(Car.class, id);
		return car;
	}
	
	public void update(Car car){
		manager.getTransaction().begin();
		manager.merge(car);
		manager.getTransaction().commit();
	}
	
	public void insert(Car car){
		manager.getTransaction().begin();
		manager.persist(car);
		manager.getTransaction().commit();
	}

	public void delete(Long id){
		//manager.remove(manager.contains(car) ? car : manager.merge(car));	
	}

	public List<CarSpecification> findByState(StatesBr state) {
		String jpql = "SELECT new " + CarSpecification.class.getName() + "(c.id, c.model, c.manufacturer)"
				+ " from Car c WHERE c.state = :state";

		manager.getTransaction().begin();
		TypedQuery<CarSpecification> query = manager.createQuery(jpql,CarSpecification.class);
		query.setParameter("state", state);

		List<CarSpecification> listByState = query.getResultList();
		manager.getTransaction().commit();

		return listByState;
	}
}
