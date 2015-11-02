package com.alucarweb.rent;

import java.util.List;

import javax.inject.Inject;

import com.alucarweb.agency.Agency;
import com.alucarweb.annotation.NotLogged;
import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.car.Car;
import com.alucarweb.client.Client;
import com.alucarweb.dao.AgencyDAO;
import com.alucarweb.dao.CarDao;
import com.alucarweb.dao.ClientDAO;
import com.alucarweb.dao.PaymentDAO;
import com.alucarweb.devolution.Devolution;
import com.alucarweb.devolution.DevolutionDAO;
import com.alucarweb.payment.Payment;
import com.alucarweb.status.RentStatus;
import com.alucarweb.user.LoggedUser;

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
	private PaymentDAO paymentDAO;
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
	
	@Inject
	private LoggedUser loggedUser;
	
	
	@Get("/locacoes")
	public void list() {
		List<Rent> rents = rentDAO.findAll();
		result.include("rents", rents);
	}
	
	@Get("/locacao")
	public void form(long carId){
		Car car = carDAO.findById(carId); //TODO - CAR ID INVALIDO
		
		List<Client> clients = clientDAO.findAll();
		List<Agency> agencies = agencyDAO.findAll();
		
		result.include("agencies",agencies);
		result.include("car",car);
		result.include("clients", clients);
		result.forwardTo("WEB-INF/jsp/rent/new.jsp");
	}
	
	@Get("/locacao/{rentId}")
	public void rent(long rentId){
		List<Agency> agencies = agencyDAO.findAll();
		Rent rent = rentDAO.findById(rentId);
		
		if(rent.getStatus() != RentStatus.IN_PROGRESS){
			Devolution devolution = devolutionDAO.findByRentId(rentId);
			result.include("devolution",devolution);
			
			if(rent.getStatus() == RentStatus.FINISHED){
				Payment payment = paymentDAO.findByRent(rentId);
				result.include("payment",payment);
			}
		}
		
		result.include("agencies",agencies);
		result.include("rent",rent);		
	}
	
	@TransactionRequired
	@Post("/locacoes")
	public void create(Rent rent){
		rent.setStatus(RentStatus.IN_PROGRESS);
		rent.setAgency(loggedUser.getAgency());
		rentDAO.alocate(rent);
		result.redirectTo(RentController.class).list();
	}
	
	@Post("/locacao/{rentId}")
	public void devolve(Long rentId){
		result.include("devolutionIsEnabled",true);
		result.redirectTo(this).rent(rentId);
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
