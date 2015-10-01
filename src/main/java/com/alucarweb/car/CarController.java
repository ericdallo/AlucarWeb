package com.alucarweb.car;

import java.util.List;

import javax.inject.Inject;

import com.alucarweb.annotations.NotLogged;
import com.alucarweb.dao.CarDao;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class CarController {	
	@Inject 
	private CarDao carDao;
	@Inject
	private Result result;	
	
	@Get("/automoveis")
	public void search(){
		List<Car> cars = carDao.searchAll();
		if(cars == null){
			result.include("empty", "empty");
		}
		result.include("cars",cars);
	}
	
	@NotLogged
	@Get("/automovel/{id}")	
	public void show(long id){
		Car car = carDao.searchById(id);
		//TODO - VALIDAR CARRO NULL
	}
}
