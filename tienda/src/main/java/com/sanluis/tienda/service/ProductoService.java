package com.sanluis.tienda.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

	public HashMap<Producto, Integer> getProductosCantidad(HashMap<Integer, Integer> productos_carrito) {
		
		return productoDAO.getProductosCantidad(productos_carrito);
	}

	public double getTotal(HashMap<Producto, Integer> carritoUnidades) {
	    double total = 0;

	    for (Map.Entry<Producto, Integer> entry : carritoUnidades.entrySet()) {
	        Producto p = entry.getKey();
	        int ud = entry.getValue();
	        total += p.getPrecio() * ud;
	    }

	    return total;
	}

}
