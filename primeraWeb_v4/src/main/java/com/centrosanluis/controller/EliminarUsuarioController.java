package com.centrosanluis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.model.Usuario;
import com.centrosanluis.service.UsuarioService;

/**
 * Servlet implementation class EliminarController
 */
@WebServlet(name = "deleteUser", urlPatterns = { "/deleteUser" })
public class EliminarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UsuarioService usuarioService;
	
    public EliminarUsuarioController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		usuarioService = new UsuarioService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		
		Usuario u = new Usuario();
		
		u.setUsuario(usuario);
		
		if(usuarioService.deleteUser(u)) {
			response.sendRedirect("listadoUsuarios");
		}else {
			List<Usuario> listadoUsuarios = usuarioService.getUsuarios();
			
			request.setAttribute("listadoUsuarios", listadoUsuarios);
			request.setAttribute("error", "El usuario no ha podido darse de baja");
			
			request.getRequestDispatcher("private/listado.jsp").forward(request, response);
		}
	}

}
