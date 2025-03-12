package com.centrosanluis.service;

import java.util.ArrayList;
import java.util.List;

import com.centrosanluis.dao.RolDAO;
import com.centrosanluis.model.Rol;

public class RolService {

	private RolDAO rolBD;
	
	public RolService() {
		rolBD = new RolDAO();
	}
	
	public List<Rol> getRoles() {
		return rolBD.getRoles();
	}

	public boolean addRol(Rol rol) {
		return rolBD.createOrUpdateRol(rol);
	}
	
	public boolean updateRol(Rol rol) {
		if(rol.getId()!=0){
			return rolBD.createOrUpdateRol(rol);
		}else {
			return false;
		}
	}

	public boolean deleteRol(Rol rol) {
		return rolBD.deleteRol(rol);
	}
	
}
