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
	
	public HashMap<Producto, Integer> getProductosMap(String cookie) {
		HashMap<Producto, Integer> productosCantidadMap = null;
		HashMap<Integer, Integer> idsCantidadMap = null;
		
		if(!"".equals(cookie)) {
			String[] carrito_ids = cookie.split("\\?");
			productosCantidadMap = new HashMap<Producto, Integer>();
			idsCantidadMap = new HashMap<Integer, Integer>();
			
			for (String id : carrito_ids) {
	            int productoId = Integer.parseInt(id);
	            idsCantidadMap.put(productoId, idsCantidadMap.getOrDefault(productoId, 0) + 1);
	        }
			
			/* ERROR LAMBDA
			idsCantidadMap.forEach( (id, ud) -> {
				Producto p = productoDAO.getProductoById(id);
				productosCantidadMap.put(p, ud);
			});
			*/
			
			 for (Map.Entry<Integer, Integer> entry : idsCantidadMap.entrySet()) {
		            int id = entry.getKey();
		            int cantidad = entry.getValue();
		            Producto p = productoDAO.getProductoById(id);
	                if (p != null) {
	                    productosCantidadMap.put(p, cantidad);  // Modificamos fuera de la lambda
	                }
		        }
			
		}
		
		return productosCantidadMap;
	}

}
