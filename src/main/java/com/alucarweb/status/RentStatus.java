package com.alucarweb.status;

public enum RentStatus {
	IN_PROGRESS("Em Andamento"),
	WAITING_PAYMENT("Aguardando Pagamento"),
	FINISHED("Finalizado");

	private String attribute;

	RentStatus(String name) {
		this.attribute = name;
	}

	public String getAttribute() {
		return attribute;
	}

}
