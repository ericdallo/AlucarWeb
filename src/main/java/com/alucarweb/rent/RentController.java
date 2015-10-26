package com.alucarweb.rent;

import java.util.List;

import javax.inject.Inject;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.annotations.NotLogged;
import com.alucarweb.car.Car;
import com.alucarweb.client.Client;
import com.alucarweb.dao.CarDao;
import com.alucarweb.dao.ClientDAO;
import com.alucarweb.devolution.Devolution;
import com.alucarweb.devolution.DevolutionDAO;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

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
	
	@Inject
	private DevolutionDAO devolutionDAO;

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
	
	@Get("/locacao/{rentId}")
	public void edit(Long rentId){
		Rent rent = rentDao.findById(rentId);
		
		Client client = rent.getClient();
		Devolution devolution = rent.getDevolution();
		
		Long carId = rent.getCar().getId();
		
		result.include("carId",carId);
		result.include("rent",rent);
		result.include("client",client);
		
		result.include("devolution",devolution);
	}
	
	@TransactionRequired
	@Post("/locacao/{rentId}")
	public void update(Rent rent){
		
		rentDao.update(rent);
		
		result.redirectTo(this).list();
	}

	@NotLogged
	@Get("/locacoes/json/{clientName}")
	public void listJson(String clientName) {
		List<Rent> rents = rentDao.findAByClientName(clientName);
		if(rents.isEmpty()){
			result.use(Results.status()).noContent();
		}
		result.use(Results.json()).from(rents)
			.include("client")
			.include("car")
			.serialize();
	}
}
