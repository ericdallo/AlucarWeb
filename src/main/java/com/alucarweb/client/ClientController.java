package com.alucarweb.client;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.alucarweb.annotation.OnlySupervisor;
import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.dao.ClientDAO;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ClientController {
	
	@Inject
	private Result result;
	
	@Inject
	private ClientDAO clientDAO;
	
	@Inject
	private Validator validator;
	
	@OnlySupervisor
	@Get("/cliente")
	public void form() {
		result.forwardTo("WEB-INF/jsp/client/new.jsp");
	}
	
	@Get("/cliente/{id}")
	public void edit(long id) {
		Client client = clientDAO.findById(id);
		result.include("client", client);
	}	
	
	@OnlySupervisor
	@TransactionRequired()
	@Post("/clientes")
	public void insert(Client client){
		/*if(validator.hasErrors()){
			result.include("errorMsg",new SimpleMessage("errorMsg", "Informe todos os campos com *"));
			validator.onErrorForwardTo(this).form();
		}*/
		
		clientDAO.insert(client);
		result.include("client",client);
		result.use(Results.page()).of(ClientController.class).edit(client.getId());
	}
	
	@TransactionRequired
	@Post("/cliente/{id}")
	public void update(Client client) {
		validator.onErrorRedirectTo(this).edit(client.getId());
		clientDAO.update(client);
		result.redirectTo(this).edit(client.getId());
	}

	@OnlySupervisor
	@TransactionRequired
	@Delete("/cliente/{id}")
	public void delete(Long id) {
		clientDAO.delete(id);
		validator.add(new I18nMessage("msg", "client.delete.success"));
		validator.onErrorRedirectTo(this).list();
	}
	
	@Get("/clientes")
	public void list() {
		List<Client> clients = clientDAO.findAll();
		if (clients == null) {
			result.include("empty", "empty");
		}
		result.include("clients", clients);
	}
}