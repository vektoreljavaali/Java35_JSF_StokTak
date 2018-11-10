package com.vektorel.beans.admin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vektorel.dal.tblilcedao;
import com.vektorel.dal.tblildao;
import com.vektorel.dal.tblstokgirisdao;
import com.vektorel.dal.tblurundao;
import com.vektorel.models.tblil;
import com.vektorel.models.tblilce;
import com.vektorel.models.tblstokgiris;
import com.vektorel.models.tblurun;

@ManagedBean(name="stokgirisiBean")
@SessionScoped
public class stokgirisiBean {

	private Long secilenurunid;
	private Long secilenilid=-1l;
	private Long secilenilceid;
	private String url;
	tblstokgiris stk = new tblstokgiris();
	tblstokgirisdao dbstkgiris =  new tblstokgirisdao();
	tblurundao dbUrun = new tblurundao();
	tblildao dbIl = new tblildao();
	tblilcedao dbIlce = new tblilcedao();
	
	private List<tblurun> urunListesi = new ArrayList<>();
	private List<tblil> ilListesi = new ArrayList<>();
	private List<tblilce> ilceListesi = new ArrayList<>();
	private List<tblstokgiris> stkgirisListesi = new ArrayList<>();
	
	public void kaydet() {
		tblstokgiris tmp = new tblstokgiris();
		tmp.setIlceid(secilenilceid);	
		tmp.setUrl(url);
		tmp.setUrunid(secilenurunid);
		dbstkgiris.kaydet(tmp);		
	}
	
	
	
	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public List<tblstokgiris> getStkgirisListesi() {
		return dbstkgiris.viewList();
	}



	public void setStkgirisListesi(List<tblstokgiris> stkgirisListesi) {
		this.stkgirisListesi = stkgirisListesi;
	}



	public Long getSecilenurunid() {
		return secilenurunid;
	}

	public void setSecilenurunid(Long secilenurunid) {
		this.secilenurunid = secilenurunid;
	}

	public List<tblurun> getUrunListesi() {
		return dbUrun.listele(new tblurun());
	}

	public void setUrunListesi(List<tblurun> urunListesi) {
		this.urunListesi = urunListesi;
	}

	public List<tblil> getIlListesi() {
		return dbIl.listele(new tblil());
	}

	public List<tblilce> getIlceListesi() {
		return dbIlce.ilceListele(secilenilid);
	}

	public Long getSecilenilid() {
		return secilenilid;
	}

	public void setSecilenilid(Long secilenilid) {
		this.secilenilid = secilenilid;
	}

	public Long getSecilenilceid() {
		return secilenilceid;
	}

	public void setSecilenilceid(Long secilenilceid) {
		this.secilenilceid = secilenilceid;
	}
	
	
	
	
	
}
