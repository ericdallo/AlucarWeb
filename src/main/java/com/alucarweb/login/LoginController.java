package com.alucarweb.login;

import java.util.List;

import javax.inject.Inject;

import com.alucarweb.agency.Agency;
import com.alucarweb.annotation.NotLogged;
import com.alucarweb.dao.AgencyDAO;
import com.alucarweb.dao.UserDAO;
import com.alucarweb.home.HomeController;
import com.alucarweb.user.LoggedUser;
import com.alucarweb.user.User;
import com.alucarweb.util.AlucarConfig;
import com.alucarweb.util.AlucarConfig.Property;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController{
	
	@Inject
	private Result result;
	@Inject
	private UserDAO userDao;
	@Inject
	private Validator validator;
	@Inject
	private LoggedUser loggedUser;
	@Inject
	private AgencyDAO agencyDAO;
	
	@NotLogged
	@Get(value = {"/","/login"} )
	public void form(){
		if(loggedUser.getUser() != null){
			result.redirectTo(HomeController.class).home();
			return;
		}
		List<Agency> agencies = agencyDAO.findAll();
		result.include("agencies",agencies);
	}
	
	@NotLogged
	@Post("/login") 
	public void login(User user, long agency){
		loggedUser.setActualAgency(agencyDAO.findById(agency));
		
		if(AlucarConfig.get(Property.PROFILE).equals("dev")){
			result.redirectTo(HomeController.class).home();
			return;
		}
		User currentUser = userDao.validate(user.getName(),user.getPassword());
		
		if(currentUser != null){
			loggedUser.setUser(currentUser);
			result.redirectTo(HomeController.class).home();
			return;
		}
		result.include("inputError", "has-error");
		validator.add(new I18nMessage("login", "login.error.incorrect"));
		validator.onErrorUsePageOf(this).form();
	}
	
	@Post("/logout")
	public void logout() {
		this.loggedUser.setUser(null);
		result.redirectTo(LoginController.class).form();
		return;
	}
	
}