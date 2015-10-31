package com.alucarweb.devolution;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class DevolutionController {
	
	@Inject
	private Result result;

	@Inject
	private DevolutionDAO devolutionDAO;
	
	@Post("/devolucoes")
	public void grava(Devolution devolution){
		//TODO - Atualizar o status para WAITING_PAYMENT
		devolutionDAO.devolve(devolution);
		result.redirectTo("WEB-INF/jsp/rent/rent.jsp");
	}
}
