package com.alucarweb.interceptor;

import javax.inject.Inject;

import com.alucarweb.annotations.NotLogged;
import com.alucarweb.controllers.LoginController;
import com.alucarweb.user.LoggedUser;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class LoginInterceptor {
	
	@Inject	private ControllerMethod controllerMethod;
	@Inject	private LoggedUser loggedUser;
	@Inject	private Result result;
	
	@Accepts
	public boolean accept(){
		return !controllerMethod.containsAnnotation(NotLogged.class);
	}
	
	@AroundCall
	public void intercepts(SimpleInterceptorStack stack){
		
		if(loggedUser.getUser() == null){
			result.redirectTo(LoginController.class).form();
			return;
		}
		stack.next();
	}
}
