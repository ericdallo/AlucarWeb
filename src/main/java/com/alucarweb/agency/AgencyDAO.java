package com.alucarweb.agency;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alucarweb.rent.agency.Agency;

public class AgencyDAO {

	@Inject
	private EntityManager manager;

	public List<Agency> findAll() {		
		String jpql = "SELECT a from Agency a";
		TypedQuery<Agency> query = manager.createQuery(jpql, Agency.class);
		
		List<Agency> agencies = query.getResultList();
		
		return agencies;
	}
}
