package com.alucarweb.rent;

import java.util.List;

import javax.inject.Inject;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.annotations.NotLogged;
import com.alucarweb.car.Car;
import com.alucarweb.client.Client;
import com.alucarweb.dao.AgencyDAO;
import com.alucarweb.dao.CarDao;
import com.alucarweb.dao.ClientDAO;
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
	private RentDAO rentDAO;

	@Inject
	private ClientDAO clientDAO;
	
	@Inject
	private AgencyDAO agencyDAO;
	
	@Inject
	private CarDao carDAO;
	
	@Inject
	private DevolutionDAO devolutionDAO;
	
	@Get("/locacoes")
	public void list() {
		List<Rent> rents = rentDAO.findAll();
		result.include("rents", rents);
	}
	
	
	@Get("/locacao")
	public void insert(Long carId){
		//TODO - CAR ID INVALIDO
		List<Client> clients = clientDAO.findAll();
		Car car = carDAO.findById(carId);
		List<Agency> agencies = agencyDAO.findAll();
		
		result.include("agencies",agencies);
		result.include("car",car);
		result.include("clients", clients);
		result.forwardTo("WEB-INF/jsp/rent/new.jsp");
	}
	
	
	@Get("/locacao/{rentId}")
	public void rent(Long rentId){
		Rent rent = rentDAO.findById(rentId);
		result.include("rent",rent);	
	}
	
	@TransactionRequired
	@Post("/locacao/{rentId}")
	public void update(Rent rent){
		rentDAO.update(rent);
		
		result.redirectTo(this).list();
	}

	@NotLogged
	@Get("/locacoes/json/{clientName}")
	public void listJson(String clientName) {
		List<Rent> rents = rentDAO.findAllByClientName(clientName);

		if(rents.isEmpty()){
			result.use(Results.status()).noContent();
		}
		result.use(Results.json()).from(rents)
			.include("client")
			.include("car")
			.serialize();
	}
}
