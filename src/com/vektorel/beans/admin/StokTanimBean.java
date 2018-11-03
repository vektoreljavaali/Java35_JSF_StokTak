package com.vektorel.beans.admin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vektorel.dal.tblurundao;
import com.vektorel.models.tblurun;

@ManagedBean(name="stokTanimlamaBean")
@SessionScoped
public class StokTanimBean {

		
	
	private tblurun urun = new tblurun();

	private tblurundao db = new tblurundao();
	
	private List<tblurun> urunListesi = new ArrayList<>();
	
	public tblurun getUrun() {
		
		return urun;
	}

	public void setUrun(tblurun urun) {
		this.urun = new tblurun();
		this.urun = urun;
	}
	
	public void kaydet() {
		
		db.kaydet(this.urun);		
	}

	public void duzenle() {
		db.duzenle(this.urun);
	}
	
	public void sil() {
		db.sil(this.urun);		
	}
	
	public List<tblurun> getUrunListesi() {
		return db.listele(new tblurun());
	}
	
	
	
}
