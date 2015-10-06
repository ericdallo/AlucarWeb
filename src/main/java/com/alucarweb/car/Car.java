package com.alucarweb.car;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.alucarweb.car.state.StatesBr;

@Entity @Table(name="car")
public class Car {
	@Id @GeneratedValue
	private Long id;
	@NotNull
	private String model;
	
	@NotNull
	private String manufacturer;
	@NotNull
	private String city;
	@NotNull
	private String image;
	
	private String chassi;
		
	@NotNull @Enumerated(EnumType.STRING) 
	private StatesBr state;
	
	@NotNull
	private boolean available;
	
	private String licensePlate;
	private String carGroup;
	private String km;
	private String freeKm;
	private String controlKm;
	private String obs;
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getCarGroup() {
		return carGroup;
	}

	public void setcarGroup(String carGroup) {
		this.carGroup = carGroup;
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

	public StatesBr getState() {
		return state;
	}

	public void setState(StatesBr state) {
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
