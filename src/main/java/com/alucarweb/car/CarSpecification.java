package com.alucarweb.car;

public class CarSpecification {

	private Long id;
	private String model;
	private String manufacturer;

	public CarSpecification(Long id, String model, String manufacturer) {
		super();
		this.id = id;
		this.model = model;
		this.manufacturer = manufacturer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
