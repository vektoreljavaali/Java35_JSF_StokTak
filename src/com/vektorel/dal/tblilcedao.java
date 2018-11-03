package com.vektorel.dal;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.vektorel.models.tblilce;
import com.vektorel.models.tbllog;
import com.vektorel.utils.NewHibernateUtil;
import com.vektorel.utils.StaticValues;
import com.vektorel.utils.VeritabaniIsletimcisi;

public class tblilcedao extends VeritabaniIsletimcisi<tblilce>{

		/**
		 * 
		 * @param id -> il�e aramas� i�in il e ait id verilir
		 * @return  il�e listesinde verilen id(il e) ye ait il�e listesi d�n�l�r 
		 */
	    public List<tblilce> ilceListele(Long id) {
	        try{
	        ac();
	        Criteria cr =  ss.createCriteria(tblilce.class);
	        cr.add(Restrictions.eq("il_id", id));
	        List<tblilce> listem = cr.list();
	        kapat();
	        return listem;        
	          }catch(Exception ex){
	            tbllog tmp = new tbllog();
	            tmp.setHataicerigi(ex.toString());
	            tmp.setMethodadi("arama");
	            tmp.setTarihsaat(LocalDateTime.now());
	            tmp.setKullaniciadi(StaticValues.kullaniciadi);
	            log.logkayit(tmp);            
	         return null;   
	     }// hata ekranı sonu
	    }
	
}
