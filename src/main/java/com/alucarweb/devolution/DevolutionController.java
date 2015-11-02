package com.alucarweb.devolution;

import javax.inject.Inject;

import com.alucarweb.annotation.TransactionRequired;
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
	
	@Post("/devolucao/{rentId}")
	public void pay(Long rentId){
		//CALCULAR O PAGAMENTO AQUI
		
		result.include("paymentIsEnabled",true);
		result.redirectTo(RentController.class).rent(rentId);
	}
}
