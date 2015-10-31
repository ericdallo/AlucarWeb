package com.alucarweb.rent;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alucarweb.annotation.TransactionRequired;

public class RentDAO {

	@Inject
	private EntityManager manager;
	
	public List<Rent> findAll() {
		String jpql = "SELECT r FROM Rent r";

		TypedQuery<Rent> rentsQuery = manager.createQuery(jpql, Rent.class);
		List<Rent> rents = rentsQuery.getResultList();
		
		return rents;
	}
	
	
	public void alocate(Rent rent){
		manager.getTransaction().begin();
		manager.merge(rent); // Tem que ser merge e nao persist pois a Entity ja esta sendo manuzeada pelo hibernate
		//manager.persist(rent); // Tem que ser merge e nao persist pois a Entity ja esta sendo manuzeada pelo hibernate
		manager.getTransaction().commit();
	}
	
	
	public List<Rent> findAllByClientName(String clientName) {
		String jpql = "SELECT r from Rent r where r.client.name like :name";

		TypedQuery<Rent> rentsQuery = manager.createQuery(jpql, Rent.class);
		rentsQuery.setParameter("name", "%" + clientName + "%");

		return rentsQuery.getResultList();
	}
	
	public Rent findById(Long rentId) {
		return manager.find(Rent.class, rentId);
	}

	public void update(Rent rent) {
		manager.merge(rent);
	}
}
