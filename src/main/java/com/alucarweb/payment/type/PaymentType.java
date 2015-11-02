package com.alucarweb.payment.type;

public enum PaymentType {
	CREDIT("Crédito"),
	DEBIT("Débito");
	
	private String attribute;

	PaymentType(String name) {
		this.attribute = name;
	}

	public String getAttribute() {
		return attribute;
	}
}
