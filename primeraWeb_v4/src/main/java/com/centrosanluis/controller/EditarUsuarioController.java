package com.centrosanluis.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.model.Rol;
import com.centrosanluis.model.Usuario;
import com.centrosanluis.service.UsuarioService;

@WebServlet(name = "editarUsuario", urlPatterns = { "/editarUsuario" })
public class EditarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UsuarioService usuarioService;
    
    public EditarUsuarioController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		usuarioService = new UsuarioService();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String user = request.getParameter("usuario");
		int rol_id = Integer.valueOf(request.getParameter("roles_id"));
		
		Rol rol = new Rol();
		rol.setId(rol_id);
		
		Usuario usuario = new Usuario(nombre, apellidos, email, telefono, user,"",rol);
		
		if(usuarioService.editUser(usuario)) {
			response.sendRedirect("/private/index.jsp");
		} else {
			//Devolver a la pantalla de editar
		}
	}

}
