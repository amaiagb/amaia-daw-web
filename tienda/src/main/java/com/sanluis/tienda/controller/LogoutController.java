package com.sanluis.tienda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanluis.tienda.service.AdminService;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService adminService;   
	
    public LogoutController() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	adminService = new AdminService();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.getSession().removeAttribute("admin");
    	response.sendRedirect("inicio");
    }

}
