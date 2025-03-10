package com.centrosanluis.productos.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.centrosanluis.productos.dao.UsuarioDAO;
import com.centrosanluis.productos.model.Usuario;

public class UsuarioService {
	
	UsuarioDAO usuarioBD;
	
	public UsuarioService() {
		usuarioBD = new UsuarioDAO();
	}
	
	public Usuario login(Usuario usuarioLogin) {
		
		String encriptada = hashPassword(usuarioLogin.getPassword());
		usuarioLogin.setPassword(encriptada);
		
		return usuarioBD.login(usuarioLogin);
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
}
