package com.sanluis.tienda.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanluis.tienda.service.AdminService;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/private/*")
public class AuthFilter implements Filter {

	AdminService adminService;
	
    public AuthFilter() {
         
    }
    
	public void init(FilterConfig fConfig) throws ServletException {
		adminService = new AdminService();
	}

	public void destroy() {
		
  	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if(req.getSession().getAttribute("admin")!=null) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect("../login.jsp");
		}
	}


}
