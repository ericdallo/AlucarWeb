package com.alucarweb.car;

public class CarSpecification {

	private String model;
	private String manufacturer;

	public CarSpecification(String model, String manufacturer) {
		this.model = model;
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
