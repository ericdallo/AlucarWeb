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
	public void grava(Devolution devolution){
		//TODO - Atualizar o status para WAITING_PAYMENT
		devolutionDAO.returnRent(devolution);
		result.redirectTo(RentController.class).rent(devolution.getRent().getId());
	}
}
