package com.vektorel.beans;

import java.util.UUID;

import com.vektorel.utils.MailIslemleri;

public class TestRunner {

	public static void main(String[] args) {

		//UUID uiid = UUID.randomUUID();
		//System.out.println(uiid.toString());
		
		
			
		      String username = 
		         "vektoreljavaali";// change accordingly
		      String password = "vektorel2004";// change accordingly
		      MailIslemleri gondermail = new MailIslemleri(null, null, null, null);
		      gondermail.mailGonder(username, password, 
		    		  "muhammedali55@gmail.com", 
		    		  "Üyelik Aktivasyonu", 
		    		  "xdcvdcvcxvxvxv");
		
		
	}

}
