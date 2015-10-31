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
	private Devolution devolutionDAO;
	
	@Post("/devolucoes")
	public void grava(Devolution devolution){
		//TODO - Atualizar o status para WAITING_PAYMENTO
		System.out.println("Aqui você da um persist na devolucao e volta pra própria pagina, so que bloqueando os campos da devolucao, pq");
		System.out.println("o status da devolucao vai estar como WAITING_PAYMENT");
	}
}
