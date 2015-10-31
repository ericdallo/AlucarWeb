package com.alucarweb.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alucarweb.agency.Agency;

public class AgencyDAO {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AgencyDAO.class);
	
	@Inject
	private EntityManager manager;
	
	public List<Agency> findAll(){
		String jpql = "SELECT a from Agency a";
		TypedQuery<Agency> query = manager.createQuery(jpql, Agency.class);
		
		List<Agency> agencies = query.getResultList();
		
		return agencies;
	}

	public Agency findById(long id) {
		return manager.find(Agency.class, id);
	}
}
