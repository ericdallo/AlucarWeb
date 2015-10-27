package com.alucarweb.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alucarweb.agency.Agency;

public class AgencyDAO {
	
	@Inject
	private EntityManager manager;
	
	public List<Agency> findAll(){
		String jpql = "SELECT a from Agency a";
		TypedQuery<Agency> query = manager.createQuery(jpql, Agency.class);
		
		List<Agency> agencies = query.getResultList();
		
		return agencies;
	}
}
