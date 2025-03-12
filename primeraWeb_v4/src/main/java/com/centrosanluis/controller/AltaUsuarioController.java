package com.centrosanluis.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/registro")
public class AltaUsuarioController extends HttpServlet{
	
	UsuarioService usuarioService;
	RolService rolService;
	
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	usuarioService = new UsuarioService();
    	rolService = new RolService();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Entrando por GET");
    	List<Rol> roles = rolService.getRoles();
    	request.getSession().setAttribute("roles", roles);
    	System.out.println("Sesion: "+request.getSession().getAttribute("roles"));
    	response.sendRedirect("registro.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String nombre = req.getParameter("nombre");
    	String apellidos = req.getParameter("apellidos");
    	String telefono = req.getParameter("telefono");
    	String email = req.getParameter("email");
    	String usuario = req.getParameter("usuario");
    	String contrasena = req.getParameter("contrasena");
    	int idRol = Integer.valueOf(req.getParameter("rol"));
    	
    	Rol rol = new Rol();
    	rol.setId(idRol);
    	
    	Usuario nuevoUsuario = new Usuario(nombre, apellidos, email, telefono, usuario, contrasena, rol);
    	
    	if(usuarioService.addUser(nuevoUsuario)) {
    		resp.sendRedirect("login.jsp");
    	}else {
    		req.setAttribute("error", "No se ha podido dar de alta el usuario");
    		
    		List<Rol> roles = rolService.getRoles();
    		req.setAttribute("roles", roles);
    		
    		req.getRequestDispatcher("registro.jsp").forward(req, resp);
    	}
    }
}
