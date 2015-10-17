package com.alucarweb.car;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CarSpecification {

	@NotNull
	@NotEmpty
	private String model;

	@NotNull
	@NotEmpty
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
