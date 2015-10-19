package com.alucarweb.client;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.alucarweb.car.state.StatesBr;

@Entity @Table(name="client")
public class Client {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name = "cpf", unique=true)
	private String cpf;
	
	@NotNull
	private String name;
	
	@NotNull
	private Date born;
	
	@NotNull
	private String gender;
	
	@NotNull @Enumerated(EnumType.STRING) 
	private StatesBr state;
	
	@NotNull
	private String city;
	
	@NotNull
	private String address;
	
	@NotNull
	private int addressNumber; 
	
	@NotNull
	private String postalCode;
	
	private String neighborhood;
	
	@NotNull
	private String licenseCode;
	
	@NotNull
	private Date licenseValidity;
	
	@NotNull @Enumerated(EnumType.STRING) 
	private StatesBr licenseState;
	
	@NotNull
	private  String licenseCity;
	
	private String email;
	private String phone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBorn() {
		return born;
	}
	public void setBorn(Date born) {
		this.born = born;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public StatesBr getState() {
		return state;
	}
	public void setState(StatesBr state) {
		this.state = state;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(int addressNumber) {
		this.addressNumber = addressNumber;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getLicenseCode() {
		return licenseCode;
	}
	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}
	
	public Date getLicenseValidity() {
		return licenseValidity;
	}
	public void setLicenseValidity(Date licenseValidity) {
		this.licenseValidity = licenseValidity;
	}
	
	public StatesBr getLicenseState() {
		return licenseState;
	}
	public void setLicenseState(StatesBr licenseState) {
		this.licenseState = licenseState;
	}
	
	public String getLicenseCity() {
		return licenseCity;
	}
	public void setLicenseCity(String licenseCity) {
		this.licenseCity = licenseCity;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
}
