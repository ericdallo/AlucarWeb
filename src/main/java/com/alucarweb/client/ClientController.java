package com.alucarweb.client;

import java.util.Calendar;

import javax.inject.Inject;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.annotations.NotLogged;
import com.alucarweb.dao.ClientDAO;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class ClientController {
	
	@Inject
	private Result result;
	
	@Inject
	private ClientDAO clientDAO;
	
	@Inject
	private Validator validator;
	
	@Get("/cliente")
	public void form() {
		result.forwardTo("WEB-INF/jsp/client/new.jsp");
	}
	
	@Get("/cliente/{id}")
	public void edit(long id) {
		Client client = clientDAO.findById(id);
		result.include("client", client);
	}	
	
	
	@Post("/clientes")
	@TransactionRequired()
	public void insert(Client client){
		validator.onErrorRedirectTo(this).form();
		
		clientDAO.insert(client);
		
		client.setBorn(Calendar.getInstance());
		result.include("client",client);
		//result.use(Results.page()).of(ClientController.class).edit(client.getId());
		//result.forwardTo(ClientController.class).edit(1);
	}
}