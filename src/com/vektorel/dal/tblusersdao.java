package com.vektorel.dal;

import java.time.LocalDateTime;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.vektorel.models.tbllog;
import com.vektorel.models.tblusers;
import com.vektorel.utils.StaticValues;
import com.vektorel.utils.VeritabaniIsletimcisi;

public class tblusersdao extends VeritabaniIsletimcisi<tblusers>{

	


    public tblusers ara(String kullaniciadi, String sifre) {
        try{
        ac();
        Criteria cr = ss.createCriteria(tblusers.class);
        cr.add(Restrictions.eq("kullaniciadi", kullaniciadi));
        cr.add(Restrictions.eq("sifre", sifre));
        tblusers tmp = (tblusers)cr.list().get(0);
        kapat();
        return tmp;        
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
    
    public tblusers ara(String kod) {
        try{
        ac();
        Criteria cr = ss.createCriteria(tblusers.class);
        cr.add(Restrictions.eq("kod", kod));
        
        tblusers tmp = (tblusers)cr.list().get(0);
        kapat();
        return tmp;        
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
