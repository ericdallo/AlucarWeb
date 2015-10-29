package com.alucarweb.interceptor;

import javax.inject.Inject;

import com.alucarweb.annotation.OnlySupervisor;
import com.alucarweb.home.HomeController;
import com.alucarweb.user.LoggedUser;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@AcceptsWithAnnotations(OnlySupervisor.class)
@Intercepts(after=LoginInterceptor.class)
public class PermissionInterceptor {
	
	@Inject	private LoggedUser loggedUser;
	@Inject	private Result result;
	
	@AroundCall
	public void intercepts(SimpleInterceptorStack stack){
		
		if(loggedUser.isSupervisor()){
			stack.next();
			return;
		}
		result.redirectTo(HomeController.class).home();
	}
}
