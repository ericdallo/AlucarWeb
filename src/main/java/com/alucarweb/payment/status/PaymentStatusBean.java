package com.alucarweb.payment.status;

import java.util.Arrays;
import java.util.List;

public class PaymentStatusBean {
	public List<PaymentStatus> getList() {
		return Arrays.asList(PaymentStatus.values());
	}
}
