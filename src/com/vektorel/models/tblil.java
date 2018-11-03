package com.vektorel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class tblil {

	@Id
	@SequenceGenerator(name="sq_tblil_id",
					 sequenceName="sq_tblil_id",
					 initialValue=1,allocationSize=1)
	@GeneratedValue(generator="sq_tblil_id")
	private Long id;
	private String ad;
	private String plakano;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getPlakano() {
		return plakano;
	}
	public void setPlakano(String plakano) {
		this.plakano = plakano;
	}
	
	
	
}
