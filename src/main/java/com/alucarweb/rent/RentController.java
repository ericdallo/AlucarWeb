package com.alucarweb.rent;

import java.util.List;

import javax.inject.Inject;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.car.Car;
import com.alucarweb.client.Client;
import com.alucarweb.dao.CarDao;
import com.alucarweb.dao.ClientDAO;
import com.alucarweb.devolution.Devolution;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class RentController {

	@Inject
	private Result result;

	@Inject
	private RentDao rentDao;

	@Inject
	private ClientDAO clientDao;

	@Inject
	private CarDao carDao;

	@Get("/locacao")
	public void rent(long carId) {
		result.include("carId", carId);

		List<Client> clients = clientDao.findAll();

		result.include("clients", clients);
		result.forwardTo("WEB-INF/jsp/rent/rent.jsp");
	}

	@TransactionRequired
	@Post("/locar")
	public void locate(Rent rent, Devolution devolution) {
		Client client = clientDao.findById(rent.getClient().getId());
		Car car = carDao.findById(rent.getCar().getId());

		rentDao.locate(rent, client, car, devolution);

		result.forwardTo(this).list();
	}

	@Get("/locacoes")
	public void list() {
		List<Rent> rents = rentDao.findAll();
		result.include("rents", rents);
	}
	
	@Get("/locacao/{id}")
	public void edit(){
		
	}

}
