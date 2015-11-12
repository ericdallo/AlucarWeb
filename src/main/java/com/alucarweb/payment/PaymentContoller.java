package com.alucarweb.payment;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import com.alucarweb.annotation.TransactionRequired;
import com.alucarweb.dao.PaymentDAO;
import com.alucarweb.payment.status.PaymentStatus;
import com.alucarweb.payment.type.PaymentType;
import com.alucarweb.rent.RentController;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class PaymentContoller {

	@Inject
	private Result result;
		
	@Inject
	private PaymentDAO paymentDAO;
	
	@Inject
	private Validator validator;
		
	@TransactionRequired
	@Post("/pagamentos")
	public void finish(Payment payment){
		payment.setStatus(PaymentStatus.PAYED);
		
		//TODO
		if(payment.getHoldersName() != null && payment.getCpf() != null){
			if(payment.getType() == PaymentType.CREDIT){
				if(payment.getCardNumber() != null && payment.getCardDate() != null && payment.getSafeCode() != null){
					paymentDAO.finish(payment);
					result.redirectTo(RentController.class).rent(payment.getRent().getId());
					return;
				}
			}else{
				if(payment.getBank() != null && payment.getBankAgency() != null && payment.getAccount() != null && payment.getPhone() != null){
					paymentDAO.finish(payment);
					result.redirectTo(RentController.class).rent(payment.getRent().getId());
					return;
				}

			}
		}
		result.include("paymentIsEnabled",true);
		result.include("paymentReturn",payment);
		validator.add(new I18nMessage("payment", "payment.error"));
		validator.onErrorRedirectTo(RentController.class).rent(payment.getRent().getId());
	}
}
