package com.alucarweb.devolution;

import javax.inject.Inject;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.killometer.KillometerType;
import com.alucarweb.payment.PaymentService;
import com.alucarweb.rent.Rent;
import com.alucarweb.rent.RentController;
import com.alucarweb.rent.RentDAO;
import com.alucarweb.util.AlucarConfig;
import com.alucarweb.util.AlucarConfig.Property;
import com.alucarweb.util.DateUtil;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class DevolutionController {
	
	@Inject
	private Result result;
	
	@Inject
	private RentDAO rentDAO;

	@Inject
	private DevolutionDAO devolutionDAO;
	
	@TransactionRequired
	@Post("/devolucoes")
	public void save(Devolution devolution){
		Rent rent = rentDAO.findById(devolution.getRent().getId());		

		Double totalValue = rent.calculateTotalValue();
		
		PaymentService paymentService = new PaymentService(totalValue);
		paymentService.checkFines(rent,devolution);
		
		devolution.setTotalValue(totalValue);
		
		devolutionDAO.returnRent(devolution);
		result.redirectTo(RentController.class).rent(devolution.getRent().getId());
	}
	
	@Post("/devolucao/{devolutionId}")
	public void pay(long devolutionId){
		Rent rent = devolutionDAO.findRentByDevolutionId(devolutionId);
		
		result.include("paymentIsEnabled",true);
		result.redirectTo(RentController.class).rent(rent.getId());
	}

}
