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
		
		// Excel Dosyasý için Okuma Tablosu oluþturuyoruz.
		public static XSSFSheet xlsTablo ;
		
	    public void handleFileUpload(FileUploadEvent event) throws Exception {
	    	
	    	// Sayfada seçilen dosyanýn upload edildiðinde yakalanmasý ve
	    	// uploadfile olarak alýnmasý için kullanýlýr.
	    	file = event.getFile();
	    	
	    	// Yeni geçici bir excel dosyasý oluþturuyoruz.
	    	File dosya= new File("tmp.xlsx");
	    	// Sayafadan yüklenem uploadfile okunarak oluþturduðumuz geçici 
	    	// excel dosyasýna kopyalanýr.
			FileUtils.copyInputStreamToFile(file.getInputstream(), dosya);
			
			// Kullanýlacak excel dosyasýna dönüþ
			XSSFWorkbook workbook = new XSSFWorkbook(dosya);
			
			// Ýlgili excel dosyasýnda ilk sayfasý seçiyoruz.
			xlsTablo = workbook.getSheetAt(0);
	 
			 
			workbook.close();
	    	
	    	FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    
	    
	    public void upload() {
	    	
	    	
	    		int toplamsatir = xlsTablo.getLastRowNum()+1;
	    		
	    		tblurun urun;
	    		for(int i=1;i<toplamsatir;i++) {
	    			// her satýrý ayrý ayrý alarak içindeki hücreleri dolaþýyoruz.
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
	    			    		
	    	
	    	    FacesMessage message = new FacesMessage("Ýþlem TAMAM", 
	    	    		"Kayýt Ýþlemi Baþarý ile tamamlanmýþtýr.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	

	
}
