package com.vektorel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class tblilce {

	@Id
	@SequenceGenerator(name="sq_tblilce_id",
					 sequenceName="sq_tblilce_id",
					 initialValue=1,allocationSize=1)
	@GeneratedValue(generator="sq_tblilce_id")
	private Long id;
	private String ad;
	private Long il_id;
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
	public Long getIl_id() {
		return il_id;
	}
	public void setIl_id(Long il_id) {
		this.il_id = il_id;
	}
	
	
}
