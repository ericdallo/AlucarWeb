package com.alucarweb.devolution;

import java.util.Calendar;

import javax.inject.Inject;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.payment.PaymentService;
import com.alucarweb.rent.Rent;
import com.alucarweb.rent.RentController;
import com.alucarweb.rent.RentDAO;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class DevolutionController {
	
	@Inject
	private Result result;
	
	@Inject
	private RentDAO rentDAO;

	@Inject
	private DevolutionDAO devolutionDAO;
	
	@Inject
	private Validator validator;
	
	@TransactionRequired
	@Post("/devolucoes")
	public void save(Devolution devolution){
		
		if(devolution.getDate() == null){
			validator.add(new I18nMessage("date", "devolution.error.date"));
			result.include("devolutionIsEnabled",true);
			validator.onErrorRedirectTo(RentController.class).rent(devolution.getRent().getId());
			return;
		}
		
//		validator.addIf(devolution.getDate() == null,new I18nMessage("date", "devolution.error.date"));
//		result.include("devolutionIsEnabled",true);
//		validator.onErrorRedirectTo(RentController.class).rent(devolution.getRent().getId());
//		
//		validator.addIf(!devolution.getDate().after(Calendar.getInstance()), new I18nMessage("dateMinor", "devolution.error.dateMinor"));
//		result.include("devolutionIsEnabled",true);
//		validator.onErrorRedirectTo(RentController.class).rent(devolution.getRent().getId());
		
		
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
