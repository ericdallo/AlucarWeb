package com.alucarweb.devolution;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity @Table(name="devolution")
public class Devolution {
	
	@Id @GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Calendar devolutionExpectedDate;
	
	@Temporal(TemporalType.DATE)
	private Calendar devolutionDate;
	
	private double totalValue;
	//TODO - AGENCIA ALOCADA E AGENCIA DEVOLVIDA - ERIC	
}
