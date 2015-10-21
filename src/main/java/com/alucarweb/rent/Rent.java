package com.alucarweb.rent;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.alucarweb.car.Car;
import com.alucarweb.devolution.Devolution;

@Entity @Table(name="rent")
public class Rent {
	
	@Id @GeneratedValue
	private Integer id;
	
	//@OneToOne(mappedBy="cliente")
	//private Cliente cliente;
	
	@OneToOne
	private Car car;
	
	@PrimaryKeyJoinColumn
	@OneToOne(cascade=CascadeType.ALL)
	private Devolution devolution;
	
	@Temporal(TemporalType.DATE)
	private Calendar createdAt;
	
	@Enumerated(EnumType.STRING)
	private KillometerType killometerType;
	
	@Enumerated(EnumType.STRING)
	private RentStatus status;
	
	private double totalValue;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Devolution getDevolution() {
		return devolution;
	}

	public void setDevolution(Devolution devolution) {
		this.devolution = devolution;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public KillometerType getKillometerType() {
		return killometerType;
	}

	public void setKillometerType(KillometerType killometerType) {
		this.killometerType = killometerType;
	}

	public RentStatus getStatus() {
		return status;
	}

	public void setStatus(RentStatus status) {
		this.status = status;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	@PrePersist
	protected void onCreate() {
	    this.createdAt = Calendar.getInstance();
	}
	
	
}
