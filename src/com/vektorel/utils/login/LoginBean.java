package com.vektorel.utils.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.vektorel.dal.tblusersdao;
import com.vektorel.models.tblusers;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

	private String kullaniciadi;
	private String sifre;
	public int yetkiid=0;
	public boolean islogged=false;
	private String mesaj="";
	private tblusersdao db = new tblusersdao();
	
	@ManagedProperty(value="#{navigationsBean}")
	private Navigations navi;
	
	public String girisYap() {
		
		tblusers usr = db.ara(kullaniciadi, sifre);
		
		StaticValues.usr = usr;
		if(usr !=null && usr.getAktivasyonid()==0) {
			mesaj ="Bu Üyelik Aktif Deðildir. "
					+ " \n Lütfen Mail Adresinize gelen link ile "
					+ " \n Aktvasyon yapýnýz";
			return navi.LoginSayfasiRedirect();
		}
		
		if(usr != null && usr.getYetkiid()==1) {
			islogged= true;
			yetkiid = 1;
			return navi.AdminAnasayfaRedirect();
		}
		if(usr != null && usr.getYetkiid()==2) {
			islogged= true;
			yetkiid = 2;
			return navi.AdminAnasayfaRedirect();
		}
		
		else
		{
			mesaj ="Kullanici adý yada Þifre hatalýdýr";
			return navi.LoginSayfasiRedirect();
		}
		
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

	public Navigations getNavi() {
		return navi;
	}

	public void setNavi(Navigations navi) {
		this.navi = navi;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	
	
	
}
