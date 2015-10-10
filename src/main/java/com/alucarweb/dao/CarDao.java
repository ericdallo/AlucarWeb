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

	public List<Car> findAll() {
		List<Car> carros = manager.createQuery("select c from Car as c where available = true").getResultList();
		return carros;
	}

	public Car findById(long id) {
		Car car = manager.find(Car.class, id);
		return car;
	}

	public void update(Car car) {
		manager.merge(car);
	}

	public void insert(Car car) {
		manager.persist(car);
		manager.flush();
	}

	public void delete(Long id) {
		Car carToRemove = manager.find(Car.class, id); 
		manager.remove(carToRemove);
	}

	public List<CarSpecification> findByState(StatesBr state) {
		String jpql = "SELECT new " + CarSpecification.class.getName() + "(c.id, c.model, c.manufacturer)"
				+ " from Car c WHERE c.state = :state";

		TypedQuery<CarSpecification> query = manager.createQuery(jpql, CarSpecification.class);
		query.setParameter("state", state);

		List<CarSpecification> listByState = query.getResultList();

		return listByState;
	}

	public List<Car> findByCarSpecification(CarSpecification spec) {
		String jpql = "SELECT c FROM Car c WHERE c.model = :model AND c.manufacturer = :manufacturer";

		manager.getTransaction().begin();

		TypedQuery<Car> query = manager.createQuery(jpql, Car.class);
		query.setParameter("model", spec.getModel());
		query.setParameter("manufacturer", spec.getManufacturer());

		List<Car> listBySpec = query.getResultList();

		manager.getTransaction().commit();

		return listBySpec;
	}
}
