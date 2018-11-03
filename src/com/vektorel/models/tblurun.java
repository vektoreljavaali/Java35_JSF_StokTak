package com.vektorel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class tblurun {

	@Id
	@SequenceGenerator(name="sq_tblurun_id",
					 sequenceName="sq_tblurun_id",
					 initialValue=1,allocationSize=1)
	@GeneratedValue(generator="sq_tblurun_id")
	private Long id;
	private String ad;
	private String barkod;
	private int adet;
	private Double fiyat;
	private int kdv;
	
	
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
	public String getBarkod() {
		return barkod;
	}
	public void setBarkod(String barkod) {
		this.barkod = barkod;
	}
	public int getAdet() {
		return adet;
	}
	public void setAdet(int adet) {
		this.adet = adet;
	}
	public Double getFiyat() {
		return fiyat;
	}
	public void setFiyat(Double fiyat) {
		this.fiyat = fiyat;
	}
	public int getKdv() {
		return kdv;
	}
	public void setKdv(int kdv) {
		this.kdv = kdv;
	}
	
	
	
}
