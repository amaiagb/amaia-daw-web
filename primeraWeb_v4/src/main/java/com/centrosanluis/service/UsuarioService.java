package com.centrosanluis.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import com.centrosanluis.dao.UsuarioDAO;
import com.centrosanluis.model.Usuario;

public class UsuarioService {
	
	UsuarioDAO usuarioBD;
	
	public UsuarioService() {
		usuarioBD = new UsuarioDAO();
	}
	
	public Usuario login(Usuario usuario) {
		String hashedPass = hashPassword(usuario.getContrasena());
		
		usuario.setContrasena(hashedPass);
		
		return usuarioBD.login(usuario);
	}

	public boolean addUser(Usuario nuevoUsuario) {
		String hashedPass = hashPassword(nuevoUsuario.getContrasena());
		
		nuevoUsuario.setContrasena(hashedPass);
		
		return usuarioBD.addUser(nuevoUsuario);
	}
	
	public ArrayList<Usuario> getUsuarios() {	
		return usuarioBD.getUsuarios();
	}
	
	private String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes());
			StringBuilder hexString = new StringBuilder();
			for(byte b: hash) {
				hexString.append(String.format("%02x", b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}

	public boolean editUser(Usuario usuario) {
		return usuarioBD.editUser(usuario);
	}
	
	public void deleteUser(String user) {
		
		usuarioBD.deleteUser(user);
		
	}

}
