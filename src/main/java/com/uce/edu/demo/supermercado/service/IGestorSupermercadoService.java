package com.uce.edu.demo.supermercado.service;

import com.uce.edu.demo.supermercado.repository.modelo.Producto;

public interface IGestorSupermercadoService {

	public void ingresarProducto(Producto producto, Integer stock);
	
	
}
