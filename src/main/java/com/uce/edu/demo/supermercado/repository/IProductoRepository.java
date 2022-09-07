package com.uce.edu.demo.supermercado.repository;

import com.uce.edu.demo.supermercado.repository.modelo.Producto;
import com.uce.edu.demo.supermercado.repository.modelo.dto.ListaProductos;

public interface IProductoRepository {

	
	void insertar(Producto producto);

	void actualizar(Producto producto);

	public Producto buscarPorCodigoBarras(String codigoBarras);
	
	public Producto buscarPorCodigoBarrasCriteria(String codigoBarras);
	
	public ListaProductos buscarProducto(String codigoBarras, Integer integer);
	
}
