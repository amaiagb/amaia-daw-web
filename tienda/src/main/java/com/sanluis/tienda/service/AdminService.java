package com.sanluis.tienda.service;

import com.sanluis.tienda.DAO.AdminDAO;
import com.sanluis.tienda.model.Admin;

public class AdminService {

	AdminDAO adminDAO = new AdminDAO();
	
	public Admin login(Admin admin) {
		
		return adminDAO.login(admin);
	}

}
