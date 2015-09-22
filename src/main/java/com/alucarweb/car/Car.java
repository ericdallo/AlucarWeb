package com.alucarweb.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity @Table(name="car")
public class Car {
	
	@Id @GeneratedValue
	private long id;
	@NotNull
	private String model;
	@NotNull
	private String manufacturer;
	@NotNull
	private String city;
	@NotNull
	private String image;
	
	private String chassi;
	private String state;
	private String licensePlate;
	private String group;
	private String km;
	private String freeKm;
	private String controlKm;
	private String obs;
	
	public Car(long id, String chassi, String model, String license, String group, String manufacturer, String city,
			String state, String km, String freeKm, String controlKm, String image, String obs) {
		super();
		this.id = id;
		this.chassi = chassi;
		this.model = model;
		this.licensePlate = license;
		this.group = group;
		this.manufacturer = manufacturer;
		this.city = city;
		this.state = state;
		this.km = km;
		this.freeKm = freeKm;
		this.controlKm = controlKm;
		this.image = image;
		this.obs = obs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicense() {
		return licensePlate;
	}

	public void setLicense(String license) {
		this.licensePlate = license;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getFreeKm() {
		return freeKm;
	}

	public void setFreeKm(String freeKm) {
		this.freeKm = freeKm;
	}

	public String getControlKm() {
		return controlKm;
	}

	public void setControlKm(String controlKm) {
		this.controlKm = controlKm;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	
}
