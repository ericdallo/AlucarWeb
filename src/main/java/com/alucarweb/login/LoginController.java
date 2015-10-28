package com.alucarweb.login;

import javax.inject.Inject;
import javax.validation.Valid;

import com.alucarweb.annotations.NotLogged;
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
	
	@NotLogged
	@Get(value = {"/","/login"} )
	public void form(){
		if(loggedUser.getUser() != null){
			result.redirectTo(HomeController.class).home();
			return;
		}
	}
	
	@NotLogged
	@Post("/login") 
	public void login(User user){
		if(AlucarConfig.get(Property.PROFILE).equals("dev")){
			result.redirectTo(HomeController.class).home();
			return;
		}
		if(userDao.validate(user)){
			
			loggedUser.setUser(user);
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