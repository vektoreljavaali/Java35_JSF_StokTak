package com.vektorel.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.vektorel.dal.tblusersdao;
import com.vektorel.models.tblusers;

@ManagedBean(name="aktivasonBean")
@SessionScoped
public class AktivasyonBean {

	//http://localhost:8080/JEE002_StokTakipProjesi/aktivasyon.jsf?kod=679058dc-7a48-48f3-8b45-432b5a072ed8

	private String gelenkod;
	
	tblusersdao db = new tblusersdao();
	
	
	
	public String getGelenkod() {
		tblusers tmp = new tblusers();
		int durum=0;
		try {
		String kod = ((HttpServletRequest)
				FacesContext.getCurrentInstance().getExternalContext().getRequest())
				.getParameter("kod"); 
			
		
		tmp = db.ara(kod);
		tmp.setAktivasyonid(1);
		db.duzenle(tmp);
		
		durum=1;
		
		}catch(Exception ex) {
			System.out.println(ex.toString());
			durum=0;
		}
		
		if(durum==0) {
			return "Beklenmeyen bir hata oldu...";
		}
		else
			return "Aktivasyon Ýþlemi Tamalanmýþtýr.";
		
		
	}

	public void setGelenkod(String gelenkod) {
		this.gelenkod = gelenkod;
	}
	
	
	
}
