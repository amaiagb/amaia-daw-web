package com.sanluis.tienda.service;

import java.util.ArrayList;

import com.sanluis.tienda.DAO.ProductoDAO;
import com.sanluis.tienda.model.Producto;

public class ProductoService {
	
	ProductoDAO productoDAO = new ProductoDAO();

	public ArrayList<Producto> getProductos() {
		
		return productoDAO.getProductos();
	}

	public Producto getProductoById(int id) {
		return productoDAO.getProductoById(id);
	}

}
