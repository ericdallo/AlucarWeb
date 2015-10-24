package com.alucarweb.payment.status;

public enum PaymentStatus {
	PAYED("Pago"),
	RETURN("Reembolsado"),
	LATE("Atrasado"),
	WAITING("Aguardando");
	
	private String attribute;

	PaymentStatus(String name) {
		this.attribute = name;
	}

	public String getAttribute() {
		return attribute;
	}
	
}
