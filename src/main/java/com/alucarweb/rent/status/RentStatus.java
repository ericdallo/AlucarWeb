package com.alucarweb.rent.status;

public enum RentStatus {
	RESERVED("Reservado"),
	ISSUED("Em Andamento"),
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
