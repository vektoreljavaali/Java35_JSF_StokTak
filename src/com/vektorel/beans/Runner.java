package com.vektorel.beans;

import com.vektorel.dal.tblilcedao;
import com.vektorel.dal.tblildao;
import com.vektorel.models.tblil;
import com.vektorel.models.tblilce;

public class Runner {

	public static void main(String[] args) {
		
		tblildao db = new tblildao();
		tblilcedao dbilce = new tblilcedao();
		
		tblil il;
		tblilce ilce ;
		il = new tblil();
		il.setAd("Adana");
		il.setPlakano("01");
		db.kaydet(il);
		il = new tblil();
		il.setAd("Adýyaman");
		il.setPlakano("02");
		db.kaydet(il);
		il = new tblil();
		il.setAd("Afyon");
		il.setPlakano("03");
		db.kaydet(il);
		il = new tblil();
		il.setAd("Aðrý");
		il.setPlakano("04");
		db.kaydet(il);
		il = new tblil();
		il.setAd("Amasya");
		il.setPlakano("05");
		db.kaydet(il);
		il = new tblil();
		il.setAd("Ankara");
		il.setPlakano("06");
		db.kaydet(il);
		
		
		ilce = new tblilce();
		ilce.setAd("Çankaya");
		ilce.setIl_id(6l);
		dbilce.kaydet(ilce);
		
		ilce = new tblilce();
		ilce.setAd("Keçiören");
		ilce.setIl_id(6l);
		dbilce.kaydet(ilce);
		
		ilce = new tblilce();
		ilce.setAd("Yenimahalle");
		ilce.setIl_id(6l);
		dbilce.kaydet(ilce);
		
		ilce = new tblilce();
		ilce.setAd("Mamak");
		ilce.setIl_id(6l);
		dbilce.kaydet(ilce);
		

	}

}
