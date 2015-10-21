package com.alucarweb.rent;

import javax.inject.Inject;

import com.alucarweb.car.Car;
import com.alucarweb.dao.ClientDAO;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class RentController {

	@Inject
	private Result result;

	@Inject
	private RentDao dao;
	
	@Inject
	private ClientDAO clientDao;

	@Get("/locacao")
	public void rent(long carId) {
		result.include("carId", carId);
		
		result.include("clients",);
		result.forwardTo("WEB-INF/jsp/rent/rent.jsp");
	}

}
