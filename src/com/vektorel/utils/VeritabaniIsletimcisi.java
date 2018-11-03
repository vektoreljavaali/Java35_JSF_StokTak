/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.utils;

import com.vektorel.models.tbllog;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vektorel
 */
public class VeritabaniIsletimcisi<M> implements ICRUD<M>{

    public  Session ss;
    public Transaction tt;
    public LogKayit log = new LogKayit();
    public void ac(){
     ss = NewHibernateUtil.getSessionFactory().openSession();
     tt = ss.beginTransaction();
    }    
    
    public void kapat(){
    tt.commit();
    ss.close();
    }
    
    @Override
    public void kaydet(M t) {
        try{
        ac();
        ss.save(t);
        kapat();
        }catch(Exception ex){
            tbllog tmp = new tbllog();
            tmp.setHataicerigi(ex.toString());
            tmp.setMethodadi("kaydet");
            tmp.setTarihsaat(LocalDateTime.now());
            tmp.setKullaniciadi(StaticValues.kullaniciadi);
            log.logkayit(tmp);
            
        }// hata ekranı sonu
    }// kaydet methodu sonu

    @Override
    public void duzenle(M t) {
        try{
        ac();
        ss.update(t);
        kapat();
        }catch(Exception ex){
            tbllog tmp = new tbllog();
            tmp.setHataicerigi(ex.toString());
            tmp.setMethodadi("düzenle");
            tmp.setTarihsaat(LocalDateTime.now());
            tmp.setKullaniciadi(StaticValues.kullaniciadi);
             log.logkayit(tmp);           
            
     }// hata ekranı sonu
    }// düzenle methodu sonu

    @Override
    public void sil(M t) {
        try{
        ac();
        ss.delete(t);
        kapat();
        }catch(Exception ex){
            tbllog tmp = new tbllog();
            tmp.setHataicerigi(ex.toString());
            tmp.setMethodadi("sil");
            tmp.setTarihsaat(LocalDateTime.now());
            tmp.setKullaniciadi(StaticValues.kullaniciadi);
            log.logkayit(tmp);            
            
     }// hata ekranı sonu
    }

    @Override
    public List<M> listele(M t) {
        try{
        ac();
        Criteria cr = ss.createCriteria(t.getClass());
        List<M> liste = cr.list();
        kapat();
        return liste;
          }catch(Exception ex){
            tbllog tmp = new tbllog();
            tmp.setHataicerigi(ex.toString());
            tmp.setMethodadi("sil");
            tmp.setTarihsaat(LocalDateTime.now());
            tmp.setKullaniciadi(StaticValues.kullaniciadi);
            log.logkayit(tmp);            
         return null;   
     }// hata ekranı sonu
    }

    @Override
    public List<M> bul(M t) {
        try{
        ac();
        Criteria cr = ss.createCriteria(t.getClass());
        //-- t nesnei içinden dolu olan alanları ekleyeceğiz.
        // Gelen Nesnenin Sınıf yapısını alyoruz.
        Class gelenT = t.getClass();
        // Sınıfın içinde bulunan alanları bir field dizisine aktarıyoruz.
        Field[] fl = gelenT.getDeclaredFields();
           
            // Nesne içinde gelen alanların tümünü tarıyoruz.
            for (Field item : fl) {
                if(item != null){
                cr.add(Restrictions.like(item.getName(),"%"+item+"%"));
               // cr.add(Restrictions.li)
                }
            }
        
        //
        List<M> liste = cr.list();
        kapat();
        return liste;
          }catch(Exception ex){
            tbllog tmp = new tbllog();
            tmp.setHataicerigi(ex.toString());
            tmp.setMethodadi("sil");
            tmp.setTarihsaat(LocalDateTime.now());
            tmp.setKullaniciadi(StaticValues.kullaniciadi);
            log.logkayit(tmp);            
         return null;   
     }// hata ekranı sonu
    }

    @Override
    public M ara(Long id, M t) {
        try{
        ac();
        Criteria cr = ss.createCriteria(t.getClass());
        cr.add(Restrictions.eq("id", id));
        M tmp = (M)cr.list().get(0);
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
