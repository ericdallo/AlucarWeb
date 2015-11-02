package com.alucarweb.payment;

import javax.inject.Inject;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.dao.PaymentDAO;
import com.alucarweb.rent.RentController;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class PaymentContoller {

	@Inject
	private Result result;

	@Inject
	private Validator validator;
	
	@Inject
	private PaymentDAO paymentDAO;
	
	@TransactionRequired
	@Post("/pagamentos")
	public void pagar(Payment payment){
		paymentDAO.pagar(payment);
		result.redirectTo(RentController.class).rent(payment.getRent().getId());
	}
}