package com.vektorel.beans.admin;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="adminIndexBean")
@SessionScoped
public class IndexBean {

	private String url="dashboard.xhtml";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void sayfaSec(int id) {
		
		switch (id) {
		case 1001:url="stoktanimlama.xhtml";break;
		case 1003:url="stokgirisi.xhtml";break;
		default:url="dashboard.xhtml";break;
		}
		
	}
	
}
