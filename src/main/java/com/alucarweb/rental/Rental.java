package com.alucarweb.rental;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.alucarweb.car.Car;

@Entity @Table(name="rental")
public class Rental {
	
	@Id @GeneratedValue
	private Integer id;
	
	//@OneToOne(mappedBy="cliente")
	//private Cliente cliente;
	
	@OneToOne
	private Car car;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar locationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar devolutionDate;
	
	@Enumerated
	private KillometerType killometerType;
	
	@Enumerated
	private RentalStatus status;
	
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

	public Calendar getLocationDate() {
		return locationDate;
	}

	public void setLocationDate(Calendar locationDate) {
		this.locationDate = locationDate;
	}

	public Calendar getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Calendar devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public KillometerType getKillometerType() {
		return killometerType;
	}

	public void setKillometerType(KillometerType killometerType) {
		this.killometerType = killometerType;
	}

	public RentalStatus getStatus() {
		return status;
	}

	public void setStatus(RentalStatus status) {
		this.status = status;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	
}
