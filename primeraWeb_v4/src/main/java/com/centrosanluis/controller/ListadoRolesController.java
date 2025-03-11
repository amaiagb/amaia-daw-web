package com.centrosanluis.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	rolService = new RolService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//llamo al service para obtener todos los roles
		ArrayList<Rol> roles = rolService.getRoles();
		
		//añado en la request el atributo (no sesion) listado roles
		request.setAttribute("roles", roles);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/private/listadoRol.jsp");
		dispatcher.forward(request, response);
		

	}


}
