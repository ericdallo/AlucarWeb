package com.alucarweb.payment.type;

import java.util.Arrays;
import java.util.List;

public class PaymentTypeBean {
	public List<PaymentType> getList() {
		return Arrays.asList(PaymentType.values());
	}
}
