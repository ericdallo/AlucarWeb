package com.alucarweb.devolution;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="devolution")
public class Devolution {
	
	@Id @GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Calendar devolutionDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Calendar devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

}
