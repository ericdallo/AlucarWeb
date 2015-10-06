package com.alucarweb.car;

import java.util.List;

import javax.inject.Inject;

import com.alucarweb.dao.CarDao;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;

@Controller
public class CarController {	
	@Inject 
	private CarDao carDao;
	@Inject
	private Result result;	
	
	@Get("/automoveis")
	public void list(){
		List<Car> cars = carDao.searchAll();
		if(cars == null){
			result.include("empty", "empty");
		}
		result.include("cars",cars);
	}
	
	@Get("/automovel")
	public void form(){
		result.forwardTo("WEB-INF/jsp/car/show.jsp");
	}
	
	@Get("/automovel/{id}")
	public void show(long id){
		Car car = carDao.searchById(id);
		result.include("car",car);
	}
	
	@Post("/automoveis")
	public void insert(Car car){
		//TODO - VALIDAR UPLOAD DE IMAGEM
		car.setImage("http://s2.glbimg.com/OxkBk1MpGYb18sqh9PhDM9kpgn0=/620x400/e.glbimg.com/og/ed/f/original/2015/01/02/mitsu_10_940x532.jpg");	
		Long id = carDao.insert(car);
		result.redirectTo(this).show(id);
	}
	
	@Put("/automovel/{id}")
	public void update(Car car){
		//TODO - VALIDAR UPLOAD DE IMAGEM
		car.setImage("http://s2.glbimg.com/OxkBk1MpGYb18sqh9PhDM9kpgn0=/620x400/e.glbimg.com/og/ed/f/original/2015/01/02/mitsu_10_940x532.jpg");	
		carDao.insert(car);
		result.redirectTo(this).show(car.getId());
	}	
}
