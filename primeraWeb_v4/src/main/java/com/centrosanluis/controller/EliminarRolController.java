package com.centrosanluis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.model.Rol;
import com.centrosanluis.model.Usuario;
import com.centrosanluis.service.RolService;
import com.centrosanluis.service.UsuarioService;

@WebServlet(name = "borrarRol", urlPatterns = { "/borrarRol" })
public class EliminarRolController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	RolService rolService;
	
    public EliminarRolController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		rolService = new RolService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rolId = Integer.valueOf(request.getParameter("rol"));
		
		Rol r = new Rol();
		r.setId(rolId);
		
		if(rolService.deleteRol(r)) {
			response.sendRedirect("listadoUsuarios");
		}else {
			List<Rol> listadoRoles = rolService.getRoles();
			
			request.setAttribute("roles", listadoRoles);
			request.setAttribute("error", "El rol no ha podido darse de baja");
			
			request.getRequestDispatcher("private/listadoRol.jsp").forward(request, response);
		}
	}

}
