package com.vektorel.dal;

import java.util.ArrayList;
import java.util.List;

import com.vektorel.models.tblil;
import com.vektorel.models.tblilce;
import com.vektorel.models.tblstokgiris;
import com.vektorel.models.tblurun;
import com.vektorel.utils.VeritabaniIsletimcisi;

public class tblstokgirisdao extends 
VeritabaniIsletimcisi<tblstokgiris>{


	tblilcedao dbilce = new tblilcedao();
	tblildao dbil = new tblildao();
	tblurundao dburun = new tblurundao();
	private Long ilid;
	
	public List<tblstokgiris> viewList(){
		List<tblstokgiris> tmplist = new ArrayList<>();
		
		tblstokgiris stk;
		for (tblstokgiris item : listele(new tblstokgiris())) {
			stk = new tblstokgiris();
			stk.setId(item.getId());
			stk.setIlceid(item.getIlceid());
			stk.setSiid(item.getSiid());
			stk.setUrunid(item.getUrunid());
			stk.setUrl(item.getUrl());
			stk.setIlceadi(ilceadiver(item.getIlceid()));
			stk.setIladi(iladiver(ilid));			
			stk.setUrunadi(urunadiver(item.getUrunid()));
			tmplist.add(stk);
			
		}
		
		return tmplist;
	}
	
	public String ilceadiver(Long id) {
	
		tblilce ilce = dbilce.ara(id, new tblilce());
		ilid = ilce.getIl_id();
		return ilce.getAd();
	}
	
	public String iladiver(Long id) {
		tblil il = dbil.ara(id, new tblil());
		return il.getAd();		
	}
	
	public String urunadiver(Long id) {
		tblurun urun = dburun.ara(id,new tblurun());
		return urun.getAd();
	}
	
}
