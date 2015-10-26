package com.alucarweb.rent;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.alucarweb.car.Car;
import com.alucarweb.client.Client;
import com.alucarweb.devolution.Devolution;

@Entity
@Table(name = "rent")
public class Rent {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Client client;

	@OneToOne
	private Car car;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Devolution devolution;

	@Temporal(TemporalType.DATE)
	private Calendar createdAt;

	@Enumerated(EnumType.STRING)
	private KillometerType killometerType;

	@Enumerated(EnumType.STRING)
	private RentStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	@PrePersist
	public void onCreate() {
		if (this.createdAt == null) {
			this.createdAt = Calendar.getInstance();
		}
	}

}