package com.alucarweb.rent;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.alucarweb.agency.Agency;
import com.alucarweb.car.Car;
import com.alucarweb.client.Client;
import com.alucarweb.killometer.KillometerType;
import com.alucarweb.payment.Payment;
import com.alucarweb.status.RentStatus;

@Entity
@Table(name="rent")
public class Rent {
	
	@Id 
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Client client;
	
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Calendar createdAt;
	
	@ManyToOne 
	private Car car;
	
	@Enumerated(EnumType.STRING)
	private RentStatus status;
	
	@ManyToOne 
	private Agency agency;
	
	@ManyToOne
	private Agency expectedAgency; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="expected_date")
	private Calendar expectedDate;
	
	@Column(name="killometer_type")
	@Enumerated(EnumType.STRING)
	private KillometerType killometerType;
	
	@OneToMany(mappedBy="rent")
	private List<Payment> payments;	
	
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

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public RentStatus getStatus() {
		return status;
	}

	public void setStatus(RentStatus status) {
		this.status = status;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public Agency getExpectedAgency() {
		return expectedAgency;
	}

	public void setExpectedAgency(Agency expectedAgency) {
		this.expectedAgency = expectedAgency;
	}

	public Calendar getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Calendar expectedDate) {
		this.expectedDate = expectedDate;
	}

	public KillometerType getKillometerType() {
		return killometerType;
	}

	public void setKillometerType(KillometerType killometerType) {
		this.killometerType = killometerType;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@PrePersist
	public void onCreate() {
		if (this.createdAt == null) {
			this.createdAt = Calendar.getInstance();
		}
	}

}