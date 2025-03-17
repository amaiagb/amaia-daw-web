package com.sanluis.tienda.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanluis.tienda.model.Admin;
import com.sanluis.tienda.service.AdminService;


@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminService adminService;   

    public LoginController() {
        super();
        
    }


	public void init(ServletConfig config) throws ServletException {
		 adminService = new AdminService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		
		Admin adminLogin = adminService.login(admin);
		
		if(adminLogin != null) {
			request.getSession().setAttribute("admin", adminLogin);
			response.sendRedirect("private/gestionProductos.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
