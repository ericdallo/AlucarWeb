package com.alucarweb.payment;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.alucarweb.payment.status.PaymentStatus;
import com.alucarweb.payment.type.PaymentType;
import com.alucarweb.rent.Rent;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Rent rent;
	
	@Temporal(TemporalType.DATE)
	private Calendar createdAt;
	
	@NotNull
	private String holdersName;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private double value;
	
	@NotNull
	private PaymentStatus status;
	
	@NotNull
	private PaymentType type;

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

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public String getHoldersName() {
		return holdersName;
	}

	public void setHoldersName(String holdersName) {
		this.holdersName = holdersName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}
	
}
