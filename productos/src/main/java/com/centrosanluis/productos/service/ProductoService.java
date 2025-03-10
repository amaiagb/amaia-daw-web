package com.centrosanluis.productos.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.centrosanluis.productos.dao.ProductoDAO;
import com.centrosanluis.productos.model.Producto;

public class ProductoService {

	ProductoDAO productoBD = new ProductoDAO();
	
	public void registrarProducto(Producto p) {
		
		try {
			productoBD.registrarProducto(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Producto> getProductos(){
		
		ArrayList<Producto> productosObtenidos = productoBD.getProductos();
		return productosObtenidos;
	}

	public Producto getProductoByID(int id) {
		
		Producto producto = productoBD.getProductoByID(id);
		return producto;
		
	}

	public void editarProducto(Producto p) {
		productoBD.editarProducto(p);
		
	}

	public void eliminarProducto(int id) {
		productoBD.eliminarProducto(id);
		
	}
}
