package com.alucarweb.interceptor;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.alucarweb.annotation.TransactionRequired;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts(after=LoginInterceptor.class)
@AcceptsWithAnnotations(TransactionRequired.class)
public class TransactionInterceptor {
	
	@Inject EntityManager manager;
	
	@AroundCall
	public void intercepts(SimpleInterceptorStack stack){
		manager.getTransaction().begin();
		stack.next();
		manager.getTransaction().commit();
	}
}
