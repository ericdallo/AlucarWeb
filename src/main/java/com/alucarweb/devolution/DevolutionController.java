package com.alucarweb.devolution;

import javax.inject.Inject;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.rent.Rent;
import com.alucarweb.rent.RentController;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class DevolutionController {
	
	@Inject
	private Result result;

	@Inject
	private DevolutionDAO devolutionDAO;
	
	@TransactionRequired
	@Post("/devolucoes")
	public void save(Devolution devolution){
		devolutionDAO.returnRent(devolution);
		result.redirectTo(RentController.class).rent(devolution.getRent().getId());
	}
	
	@Post("/devolucao/{devolutionId}")
	public void pay(long devolutionId){
		//CALCULAR O PAGAMENTO AQUI
		
		Rent rent = devolutionDAO.findRentByDevolutionId(devolutionId);
		
		result.include("paymentIsEnabled",true);
		result.redirectTo(RentController.class).rent(rent.getId());
	}
}
