package com.alucarweb.devolution;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.alucarweb.rent.Rent;
import com.alucarweb.rent.agency.Agency;

@Entity
@Table(name="devolution")
public class Devolution {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Rent rent;
	
	@OneToOne
	private Agency agency;
	
	@Temporal(TemporalType.DATE)
	@Column(name="devolution_date")
	private Calendar date;
	
	@NotNull
	private String totalValue;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public String getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}
}
