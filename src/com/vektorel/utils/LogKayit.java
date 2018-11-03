/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.utils;

import com.vektorel.models.tbllog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vektorel
 */
public class LogKayit {
    Session ss;
    Transaction tt;
    
    public void ac(){
     ss = NewHibernateUtil.getSessionFactory().openSession();
     tt = ss.beginTransaction();
    }    
    
    public void kapat(){
    tt.commit();
    ss.close();
    }
    
    public void logkayit(tbllog lg){
         try{
             ac();
             ss.save(lg);
             kapat();
        }catch(Exception ex){
             filesave(lg);
        }
           
    }
    
    
    
   
    public void filesave(tbllog lg){
    
             try{
                File fl = new File("src/main/java/com/vektorel/util/log.txt");
                BufferedWriter bf = new BufferedWriter(new FileWriter(fl,true));
                bf.write("HATA OLAYI .....: "+ lg.getTarihsaat());
                bf.newLine();
                bf.write("METHOD ADI .....: "+ lg.getMethodadi());
                bf.newLine();
                bf.write("HATA Ä°Ã‡ERÄ°Ä�Ä° .....: "+ lg.getHataicerigi());
                bf.newLine();
                bf.write("KULLANICI ADI .....: "+ lg.getKullaniciadi());
                bf.newLine();
                bf.write("---------------------------------------------------");
                bf.newLine();          
                bf.close();
         JOptionPane.showMessageDialog(null, "SÄ°STEMDE BEKLENMEYEN BÄ°R HATA OLUÅ�TU \n"
            +" LÃœTFEN SÄ°STEM YÃ–NETÄ°CÄ°NÄ°Z Ä°LE Ä°LETÄ°Å�Ä°ME GEÃ‡Ä°NÄ°Z... \n");
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "SÄ°STEMDE BEKLENMEYEN BÄ°R HATA OLUÅ�TU \n"
            +" LÃœTFEN SÄ°STEM YÃ–NETÄ°CÄ°NÄ°Z Ä°LE Ä°LETÄ°Å�Ä°ME GEÃ‡Ä°NÄ°Z... \n"+
             "HATA Ä°Ã‡ERÄ°Ä�Ä°....: "+ ex.toString());
        }
    
    }
    
}
