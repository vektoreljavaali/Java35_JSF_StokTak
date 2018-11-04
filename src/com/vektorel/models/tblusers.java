package com.vektorel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class tblusers {

	@Id
	@SequenceGenerator(name="sq_tblusers_id",
					 sequenceName="sq_tblusers_id",
					 initialValue=1,allocationSize=1)
	@GeneratedValue(generator="sq_tblusers_id")
	private Long id;
	private String kullaniciadi;
	private String sifre;
	private String adsoyad;
	private int yetkiid; // 2 ise admin 1 ise kullanici
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKullaniciadi() {
		return kullaniciadi;
	}
	public void setKullaniciadi(String kullaniciadi) {
		this.kullaniciadi = kullaniciadi;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public String getAdsoyad() {
		return adsoyad;
	}
	public void setAdsoyad(String adsoyad) {
		this.adsoyad = adsoyad;
	}
	public int getYetkiid() {
		return yetkiid;
	}
	public void setYetkiid(int yetkiid) {
		this.yetkiid = yetkiid;
	}
	
	
}
