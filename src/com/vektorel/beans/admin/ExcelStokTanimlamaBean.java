package com.vektorel.beans.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name="excelStokTanimlamaBean")
@SessionScoped
public class ExcelStokTanimlamaBean {

	 private String[] selectedCities2;
	 private List<String> cities;
	  private UploadedFile file;
	  
	    public UploadedFile getFile() {
	        return file;
	    }
	 
	    public void setFile(UploadedFile file) {
	        this.file = file;
	    }
	    
	    public void handleFileUpload(FileUploadEvent event) {
	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    public void upload() {
	    	 FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	 @PostConstruct
	    public void init() {
	        cities = new ArrayList<String>();
	        cities.add("Miami");
	        cities.add("London");
	        cities.add("Paris");
	        cities.add("Istanbul");
	        cities.add("Berlin");
	        cities.add("Barcelona");
	        cities.add("Rome");
	        cities.add("Brasilia");
	        cities.add("Amsterdam");
	         	       
	    }

	 public void yazdir() {
		 for (String string : selectedCities2) {
			System.out.println(string);
		}
		 
	 }
	 
	public String[] getSelectedCities2() {
		return selectedCities2;
	}

	public void setSelectedCities2(String[] selectedCities2) {
		this.selectedCities2 = selectedCities2;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	
}
