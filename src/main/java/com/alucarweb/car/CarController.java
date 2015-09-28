package com.alucarweb.car;

import javax.inject.Inject;

import com.alucarweb.annotations.NotLogged;
import com.alucarweb.dao.CarDao;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class CarController {	
	@Inject 
	private CarDao carDao;
	@Inject
	private Result result;
	@Inject
	private Validator validator;
	
	
	@Get("/automoveis")
	public void search(){
		
	}
	
	@Get("/automovel")	
	public void show(){
		Car car = carDao.searchById(1);
		result.include("car", car);
	}
}
