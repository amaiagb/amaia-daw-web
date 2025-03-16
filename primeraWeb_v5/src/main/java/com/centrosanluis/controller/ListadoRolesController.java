package com.centrosanluis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.model.Rol;
import com.centrosanluis.service.RolService;

/**
 * Servlet implementation class ListadoController
 */
@WebServlet("/listadoRoles")
public class ListadoRolesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RolService rolService;
	
	@Override
	public void init() throws ServletException {
		rolService = new RolService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Rol> listadoRoles = rolService.getRoles();
		
		request.setAttribute("listadoRoles", listadoRoles);
		
		request.getRequestDispatcher("private/listadoRoles.jsp").forward(request, response);
		
	}


}
