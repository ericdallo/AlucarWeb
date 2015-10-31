package com.alucarweb.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alucarweb.car.Car;
import com.alucarweb.state.StatesBr;

public class CarDao {

	@Inject
	private EntityManager manager;

	public List<Car> findAll() {
		List<Car> carros = manager.createQuery("select c from Car as c where available = true").getResultList();
		return carros;
	}
	
	public Car findById(long id) {
		return manager.find(Car.class, id);
	}

	public Car update(Car car) {
		Car newCar = manager.find(Car.class, car.getId());
		newCar.setModel(car.getModel());
		newCar.setManufacturer(car.getManufacturer());
		newCar.setModel(car.getModel());
		newCar.setChassi(car.getChassi());
		newCar.setCity(car.getCity());
		newCar.setState(car.getState());
		newCar.setLicensePlate(car.getLicensePlate());
		newCar.setCategory(car.getCategory());
		newCar.setKm(car.getKm());
		newCar.setFreeKm(car.getFreeKm());
		newCar.setControlKm(car.getControlKm());
		newCar.setObs(car.getObs());

		return newCar;
	}

	public void insert(Car car) {
		manager.persist(car);
		manager.flush();
	}

	public void delete(Long id) {
		Car carToRemove = manager.find(Car.class, id);
		manager.remove(carToRemove);
	}

	public List<Car> findByState(StatesBr state) {
		String jpql = "SELECT c FROM "+ Car.class.getSimpleName() + " c WHERE c.state = :state";

		TypedQuery<Car> query = manager.createQuery(jpql, Car.class);
		query.setParameter("state", state);

		List<Car> listByState = query.getResultList();

		return listByState;
	}
}
