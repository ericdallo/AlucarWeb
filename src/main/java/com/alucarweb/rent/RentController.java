package com.alucarweb.rent;

import javax.inject.Inject;

import com.alucarweb.car.Car;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class RentController {

	@Inject
	private Result result;

	@Inject
	private RentDao dao;

	@Get("/locacao")
	public void rent(long carId) {
		result.include("carId", carId);
		result.forwardTo("WEB-INF/jsp/rent/rent.jsp");
	}

}
