package com.vektorel.utils.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="navigationsBean") 
@SessionScoped
public class Navigations{

	public String AdminAnasayfa() {
		return "/AdminPanel/index.jsf";
	}
	
	public String AdminAnasayfaRedirect() {
		return "/AdminPanel/index.jsf?faces-redirect=true";
	}
	
	public String LoginSayfasi() {
		return "/login.jsf";		
	}
	
	public String LoginSayfasiRedirect() {
		return "/login.jsf?faces-redirect=true";		
	}
	
}
