package com.alucarweb.devolution;

import javax.inject.Inject;

import com.alucarweb.rent.Rent;
import com.alucarweb.rent.RentDao;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class DevolutionController {
	@Inject
	Result result;
	
	@Inject
	DevolutionDAO devolutionDAO;
	
	@Inject
	RentDao rentDAO;
	
	@Get("/devolucao/{id}")
	public void edit(Long id){
		Rent rent = rentDAO.findById(id);
		result.include("rent", rent);		
	}
	
	@Post("/devolucao/{id}")
	public void edit(Rent rent){
		result.include("rent",rent);
	}
	
	
}
