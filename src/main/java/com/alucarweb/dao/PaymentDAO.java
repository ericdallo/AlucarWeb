package com.alucarweb.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alucarweb.payment.Payment;
import com.alucarweb.rent.Rent;
import com.alucarweb.status.RentStatus;

public class PaymentDAO {

	@Inject
	private EntityManager manager;
	
	public void finish(Payment payment){
		manager.persist(payment);
		Rent rent = manager.find(Rent.class,payment.getRent().getId());
		rent.setStatus(RentStatus.FINISHED);
		manager.merge(rent);
	}
	
	public Payment findByRent(long rentId){
		String jpql = "SELECT p FROM Payment p WHERE p.rent.id = :rentId";			

		TypedQuery<Payment> query = manager.createQuery(jpql, Payment.class);
		query.setParameter("rentId", rentId);

		Payment payment = query.getSingleResult();
		return payment;		
	}

}