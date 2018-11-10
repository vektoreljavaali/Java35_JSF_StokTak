package com.vektorel.beans;

import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vektorel.dal.tblusersdao;
import com.vektorel.models.tblusers;

@SuppressWarnings("deprecation")
@ManagedBean(name="registerBean")
@SessionScoped
public class RegisterBean {

	private String ad;
	private String mail;
	private String username;
	private String sifre;
	private String sifre2;
	private String uyari;
	private tblusersdao db = new tblusersdao();
	public String uyeOl() {
		if(sifre.equals(sifre2)) {
			tblusers tmp = new tblusers();
			tmp.setAdsoyad(ad);
			tmp.setKullaniciadi(username);
			tmp.setSifre(sifre);
			tmp.setYetkiid(1);
			//UUID uid = new UUID(null, null);
			//uid.
			String aktivasyonurl ="http://localhost:8080/JEE002_StokTakipProjesi/";
			
			db.kaydet(tmp);
		}
		else {
			uyari = "Þifreler uyuþmuyor";
			return "register.jsf?faces-redirect=true";
		}
		
		System.out.println("Üye ad þifre....:"+ username+ " - " + sifre);
		
		return "login.jsf?faces-redirect=true";
	}
	
	public String getUyari() {
		return uyari;
	}

	public void setUyari(String uyari) {
		this.uyari = uyari;
	}

	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public String getSifre2() {
		return sifre2;
	}
	public void setSifre2(String sifre2) {
		this.sifre2 = sifre2;
	}
	
	
	
	
}
