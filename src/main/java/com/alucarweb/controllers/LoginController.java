package com.alucarweb.controllers;

import javax.inject.Inject;

import com.alucarweb.annotations.NotLogged;
import com.alucarweb.dao.UserDAO;
import com.alucarweb.user.LoggedUser;
import com.alucarweb.user.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController{

	private final Result result;
	private final UserDAO userDao;
	private final Validator validator;
	private LoggedUser loggedUser;
	
	@Inject
	public LoginController(Result result,UserDAO userDao,Validator validator,LoggedUser loggedUser) {
		this.result = result;
		this.userDao = userDao;
		this.validator = validator;
		this.loggedUser = loggedUser;
	}
	
	@Deprecated //CDI eyes only
	public LoginController() {
		this(null,null,null,null);
	}
	
	@NotLogged
	@Get("/")
	public void form(){
		if(loggedUser.getUser() != null){
			result.redirectTo(HomeController.class).home();
			return;
		}
	}
	
	@NotLogged
	@Post("/login") 
	public void login(User user){
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