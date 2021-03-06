package com.alucarweb.car;

import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import com.alucarweb.annotation.NotLogged;
import com.alucarweb.annotation.OnlySupervisor;
import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.car.images.ImagesService;
import com.alucarweb.dao.CarDao;
import com.alucarweb.state.StatesBr;
import com.alucarweb.util.NumberUtil;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class CarController {

	@Inject
	private CarDao carDao;

	@Inject
	private Result result;

	@Inject
	private Validator validator;

	@Inject
	private ImagesService images;

	@Get("/automovel")
	public void form() {
		result.forwardTo("WEB-INF/jsp/car/new.jsp");
	}

	@Get("/automovel/{id}")
	public void edit(long id) {
		Car car = carDao.findById(id);
		result.include("car", car);
	}

	@OnlySupervisor
	@TransactionRequired
	@Post("/automoveis")
	public void insert(Car car, UploadedFile imageFile) {

		validator.addIf(imageFile == null, new I18nMessage("image", "image.incorrect"));
		validator.onErrorRedirectTo(this).form();

		validateCarFields(car);

		carDao.insert(car);
		images.save(car, imageFile);

		result.include("car", car);
		result.include("carId", car.getId());
		result.redirectTo(CarController.class).list();
	}

	@TransactionRequired
	@Post("/automovel/{id}")
	public void update(Car car, UploadedFile imageFile) {
		validateCarFields(car);

		car = carDao.update(car);

		if (imageFile != null) {
			images.save(car, imageFile);
		}

		result.redirectTo(this).edit(car.getId());
	}

	@OnlySupervisor
	@TransactionRequired
	@Delete("/automovel/{id}")
	public void delete(Long id) {
		carDao.delete(id);

		validator.add(new I18nMessage("msg", "car.msg.success"));
		validator.onErrorRedirectTo(this).list();
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
	public void listJson(@NotNull StatesBr state) {
		validator.onErrorUse(Results.status()).notAcceptable();

		List<Car> cars = carDao.findByState(state);

		result.use(Results.json()).from(cars).serialize();
	}

	// @Gambiarra - Não deu tempo de configurar o hibernate validator
	public void validateCarFields(Car car) {
		if (car.getModel() == null || car.getManufacturer() == null || car.getCity() == null
				|| car.getLicensePlate() == null || car.getChassi() == null || car.getCategory() == null
				|| car.getKm() == null || car.getFreeKm() == null || car.getControlKm() == null) {
			
			validator.add(new I18nMessage("car.error.empty", "car.error.empty"));
			if(car.getId() == null){
				validator.onErrorRedirectTo(this).form();
			}else{
				validator.onErrorRedirectTo(this).edit(car.getId());
			}
			return;
		}

		if (!NumberUtil.isDouble(car.getKm())) {			
			validator.add(new I18nMessage("car.error.km", "car.error.km"));
			if(car.getId() == null){
				validator.onErrorRedirectTo(this).form();
			}else{
				validator.onErrorRedirectTo(this).edit(car.getId());
			}
			return;
		}

		if (!NumberUtil.isDouble(car.getFreeKm())) {
			validator.add(new I18nMessage("car.error.freeKm", "car.error.freeKm"));
			if(car.getId() == null){
				validator.onErrorRedirectTo(this).form();
			}else{
				validator.onErrorRedirectTo(this).edit(car.getId());
			}
			return;
		}

		if (!NumberUtil.isDouble(car.getControlKm())) {
			result.include("car", car);
			validator.add(new I18nMessage("car.error.controlKm", "car.error.controlKm"));
			if(car.getId() == null){
				validator.onErrorRedirectTo(this).form();
			}else{
				validator.onErrorRedirectTo(this).edit(car.getId());
			}
			return;
		}
	}

}
