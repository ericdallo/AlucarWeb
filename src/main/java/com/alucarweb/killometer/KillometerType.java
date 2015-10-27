package com.alucarweb.killometer;

public enum KillometerType {
	FREE("Livre"),
	CONTROLLED("Controlado");
	
	private String attribute;

	KillometerType(String name) {
		this.attribute = name;
	}

	public String getAttribute() {
		return attribute;
	}
}
