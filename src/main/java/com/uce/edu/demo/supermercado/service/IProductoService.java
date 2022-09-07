package com.uce.edu.demo.supermercado.service;

import com.uce.edu.demo.supermercado.repository.modelo.Producto;

public interface IProductoService {

	void insertar(Producto producto);

	void actualizar(Producto producto);

	Producto buscarPorCodigoBarras(String codigoBarras);
	
	public Producto buscarPorCodigoBarrasCriteria(String codigoBarras);
}
