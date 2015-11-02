package com.alucarweb.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.alucarweb.payment.Payment;

public class PaymentDAO {

	@Inject
	private EntityManager manager;
	
	public void pagar(Payment payment){
		manager.persist(payment);
	}
}
