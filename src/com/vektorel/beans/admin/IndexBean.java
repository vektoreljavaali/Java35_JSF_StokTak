package com.vektorel.beans.admin;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vektorel.models.tblusers;
import com.vektorel.utils.login.StaticValues;

@ManagedBean(name="adminIndexBean")
@SessionScoped
public class IndexBean {

	private String url="dashboard.xhtml";

	private tblusers usr = new tblusers();
	
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

	public tblusers getUsr() {
		return StaticValues.usr;
	}

	public void setUsr(tblusers usr) {
		this.usr = usr;
	}
	
	
}
