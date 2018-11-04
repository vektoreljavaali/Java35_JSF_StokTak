package com.vektorel.utils.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vektorel.models.tblusers;

@ManagedBean
@SessionScoped
public class StaticValues {

	public static tblusers usr = new tblusers();
	
	
	
}
