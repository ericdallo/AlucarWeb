package com.alucarweb.rent.agency;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.alucarweb.state.StatesBr;

@Entity
@Table(name = "agency")
public class Agency {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated
	private StatesBr state;

	@NotNull
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatesBr getState() {
		return state;
	}

	public void setState(StatesBr state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
