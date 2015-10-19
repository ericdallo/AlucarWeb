package com.alucarweb.client;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class ClientController {
	
	@Inject
	private Result result;
	
	@Get("/cliente")
	public void form() {
		result.forwardTo("WEB-INF/jsp/client/new.jsp");
	}
	
	@Get("/clientes")
	public void search() {
		
	}
}