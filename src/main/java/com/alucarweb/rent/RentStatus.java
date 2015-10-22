package com.alucarweb.rent;

public enum RentStatus {

	RESERVED("Reservado"),
	ISSUED("Em Aberto"),
	WAIT_PAYMENT("Aguardando Pagamento"),
	FINISHED("Finalizado");

	private String attribute;

	RentStatus(String name) {
		this.attribute = name;
	}

	public String getAttribute() {
		return attribute;
	}

}
