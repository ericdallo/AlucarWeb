package com.alucarweb.payment;

import javax.inject.Inject;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.dao.PaymentDAO;
import com.alucarweb.payment.status.PaymentStatus;
import com.alucarweb.rent.RentController;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class PaymentContoller {

	@Inject
	private Result result;
		
	@Inject
	private PaymentDAO paymentDAO;
		
	@TransactionRequired
	@Post("/pagamentos")
	public void finish(Payment payment){
		payment.setStatus(PaymentStatus.PAYED);
		paymentDAO.finish(payment);
		result.redirectTo(RentController.class).rent(payment.getRent().getId());
	}
}
