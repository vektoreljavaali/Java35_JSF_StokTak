package com.vektorel.beans.admin;

import java.io.File;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.vektorel.dal.tblurundao;
import com.vektorel.models.tblurun;

@SuppressWarnings("deprecation")
@ManagedBean(name="excelStokTanimlamaBean")
@SessionScoped
public class ExcelStokTanimlamaBean {

	 
		UploadedFile file;
	
		tblurundao db = new tblurundao();
		
		// Excel Dosyas� i�in Okuma Tablosu olu�turuyoruz.
		public static XSSFSheet xlsTablo ;
		
	    public void handleFileUpload(FileUploadEvent event) throws Exception {
	    	
	    	// Sayfada se�ilen dosyan�n upload edildi�inde yakalanmas� ve
	    	// uploadfile olarak al�nmas� i�in kullan�l�r.
	    	file = event.getFile();
	    	
	    	// Yeni ge�ici bir excel dosyas� olu�turuyoruz.
	    	File dosya= new File("tmp.xlsx");
	    	// Sayafadan y�klenem uploadfile okunarak olu�turdu�umuz ge�ici 
	    	// excel dosyas�na kopyalan�r.
			FileUtils.copyInputStreamToFile(file.getInputstream(), dosya);
			
			// Kullan�lacak excel dosyas�na d�n��
			XSSFWorkbook workbook = new XSSFWorkbook(dosya);
			
			// �lgili excel dosyas�nda ilk sayfas� se�iyoruz.
			xlsTablo = workbook.getSheetAt(0);
	 
			 
			workbook.close();
	    	
	    	FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    
	    
	    public void upload() {
	    	
	    	
	    		int toplamsatir = xlsTablo.getLastRowNum()+1;
	    		
	    		tblurun urun;
	    		for(int i=1;i<toplamsatir;i++) {
	    			// her sat�r� ayr� ayr� alarak i�indeki h�creleri dola��yoruz.
	    			Row satir = xlsTablo.getRow(i);
	    			urun = new tblurun();
	    			urun.setAd(satir.getCell(1).getStringCellValue());
	    			urun.setAdet(0);
	    			urun.setBarkod(satir.getCell(2).getStringCellValue());
	    			urun.setFiyat(satir.getCell(3).getNumericCellValue());
	    			urun.setId((long) satir.getCell(0).getNumericCellValue());
	    			urun.setKdv(18);
	    			db.kaydet(urun);
	    		}
	    			    		
	    	
	    	    FacesMessage message = new FacesMessage("��lem TAMAM", 
	    	    		"Kay�t ��lemi Ba�ar� ile tamamlanm��t�r.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	

	
}
