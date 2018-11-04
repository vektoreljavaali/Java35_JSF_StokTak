package com.vektorel.utils.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

	private String kullaniciadi;
	private String sifre;
	public int yetkiid=0;
	public boolean islogged=false;

	
	public String girisYap() {
		
		if(kullaniciadi.equals("admin") && sifre.equals("123")) {
			islogged= true;
			yetkiid = 1;
			return "AdminPanel/index.jsf";
		}
		else
			return "login.jsf";
		
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
	
	
	
	
}
