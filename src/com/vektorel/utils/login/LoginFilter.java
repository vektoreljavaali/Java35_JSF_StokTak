package com.vektorel.utils.login;

import java.io.IOException;

import javax.persistence.Id;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, 
						 ServletResponse response, 
						 FilterChain chain)
			throws IOException, ServletException {
		
	System.out.println("Login filter");
		
		LoginBean gelen = (LoginBean) 
				((HttpServletRequest)request).getSession().getAttribute("LoginBean");
		
		
		if(gelen==null || gelen.yetkiid==1) {
			
			String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath + "/login.jsf");
            
		}
		
		
		// bu  kodlama gelen iste�in geldi�i gibi 
		// y�nlendirilmesini sa�lamaktad�r.
		 chain.doFilter(request, response);
	}

	
}
