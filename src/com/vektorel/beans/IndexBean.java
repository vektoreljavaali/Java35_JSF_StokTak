package com.vektorel.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vektorel.models.tblmusteri;

@SuppressWarnings("deprecation")
@ManagedBean(name="indexBean")
@SessionScoped
public class IndexBean {

	private String ad;
	private String soyad;
	private String sonuc;
	private String cinsiyet;
	private int silid;
	
	private tblmusteri kytmst = new tblmusteri();
	private tblmusteri dznmst = new tblmusteri();
	
	private List<tblmusteri> mlist = new ArrayList<>();
	
	public void kaydet() {
		
		mlist.add(kytmst);	
	}
	
	public void sil() {
		mlist.remove(silid);
	}
	
	public void düzenle(int id)
	{
	
		
		
	}
	
	
	
	public tblmusteri getKytmst() {
		return kytmst;
	}

	public void setKytmst(tblmusteri kytmst) {
		this.kytmst = kytmst;
	}

	public tblmusteri getDznmst() {
		return dznmst;
	}

	public void setDznmst(tblmusteri dznmst) {
		this.dznmst = dznmst;
	}

	public int getSilid() {
		return silid;
	}

	public void setSilid(int silid) {
		this.silid = silid;
	}

	public List<tblmusteri> getMlist() {
		return mlist;
	}

	public void setMlist(List<tblmusteri> mlist) {
		this.mlist = mlist;
	}



	public String getSonuc() {
		return sonuc;
	}

	public void setSonuc(String sonuc) {
		this.sonuc = sonuc;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	
	
	
}
