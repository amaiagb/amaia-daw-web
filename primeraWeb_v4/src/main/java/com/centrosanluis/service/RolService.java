package com.centrosanluis.service;

import java.util.ArrayList;

import com.centrosanluis.dao.RolDAO;
import com.centrosanluis.model.Rol;

public class RolService {

	RolDAO rolBD = new RolDAO();
	
	public ArrayList<Rol> getRoles() {
		ArrayList<Rol> roles = rolBD.getRoles();
		System.out.println("Service: "+roles);
		return roles;
	}

	public boolean addRol(Rol rol) {
		return rolBD.createOrUpdateRol(rol);
	}
}
