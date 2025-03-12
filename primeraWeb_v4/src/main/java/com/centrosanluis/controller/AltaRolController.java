package com.centrosanluis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.model.Rol;
import com.centrosanluis.service.RolService;

@WebServlet(name = "altaRol", urlPatterns = { "/altaRol" })
public class AltaRolController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	RolService rolService;
	
	
    public AltaRolController() {
        super();
    }

    @Override
	public void init() throws ServletException {
		rolService = new RolService();
	}   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Rol rol = new Rol();
		
		String nombre = request.getParameter("nombre");
		
		rol.setNombre(nombre);
		
		if(rolService.addRol(rol)) {
			response.sendRedirect("private/index.jsp");
		}else {
			request.setAttribute("error", "No se ha podido dar de alta el usuario");
			
    		request.getRequestDispatcher("crearRol.jsp").forward(request, response);
		}
	}

}
