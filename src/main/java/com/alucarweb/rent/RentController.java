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
	public void form(Car car){
		result.include("car",car); //TODO Objeto Carro inconsistente...so com o id
	}
}
