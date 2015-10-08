package com.alucarweb.car;

import java.util.List;

import javax.inject.Inject;

import com.alucarweb.annotations.NotLogged;
import com.alucarweb.car.state.StatesBr;
import com.alucarweb.dao.CarDao;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class CarController {

	@Inject
	private CarDao carDao;

	@Inject
	private Result result;

	@Get("/automovel")
	public void form() {
		result.forwardTo("WEB-INF/jsp/car/new.jsp");
	}

	@Get("/automovel/{id}")
	public void edit(long id) {
		Car car = carDao.findById(id);
		result.include("car", car);
	}

	@Post("/automoveis")
	public void insert(Car car) {
		// TODO - VALIDAR UPLOAD DE IMAGEM
		car.setImage("http://s2.glbimg.com/OxkBk1MpGYb18sqh9PhDM9kpgn0=/620x400/e.glbimg.com/og/ed/f/original/2015/01/02/mitsu_10_940x532.jpg");
		carDao.insert(car);

		result.include("car", car);
		result.include("carId", car.getId());
		result.use(Results.page()).of(CarController.class).edit(car.getId());
	}

	@Put("/automovel/{id}")
	public void update(Car car) {
		// TODO - VALIDAR UPLOAD DE IMAGEM
		car.setImage("http://s2.glbimg.com/OxkBk1MpGYb18sqh9PhDM9kpgn0=/620x400/e.glbimg.com/og/ed/f/original/2015/01/02/mitsu_10_940x532.jpg");
		carDao.insert(car);
		result.redirectTo(this).edit(car.getId());
	}

	@Get("/automoveis")
	public void list() {
		List<Car> cars = carDao.findAll();
		if (cars == null) {
			result.include("empty", "empty");
		}
		result.include("cars", cars);
	}

	@NotLogged
	@Get("/automoveis/json/{state}")
	public void listCarSpecificationJson(StatesBr state) {
		List<CarSpecification> cars = carDao.findByState(state);

		result.use(Results.json()).from(cars).serialize();
	}

	@NotLogged
	@Get("/automoveis/json/detalhes")
	public void listCarsJson(CarSpecification spec) {
		List<Car> cars = carDao.findByCarSpecification(spec);

		result.use(Results.json()).from(cars).serialize();
	}
}
