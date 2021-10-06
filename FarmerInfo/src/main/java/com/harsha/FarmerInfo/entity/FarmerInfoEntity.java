package com.harsha.FarmerInfo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FARMERDETAILS")
public class FarmerInfoEntity {
	@Id
	@Column(name = "FARMERID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "FARMERNAME")
	private String name;
	@Column(name = "STATE")
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
