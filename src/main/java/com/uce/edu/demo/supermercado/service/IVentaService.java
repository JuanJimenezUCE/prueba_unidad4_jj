package com.uce.edu.demo.supermercado.service;

import java.util.List;

import com.uce.edu.demo.supermercado.repository.modelo.dto.ListaProductos;

public interface IVentaService {
	public void realizarVenta(List<ListaProductos> productos, String cedulaCliente, String nVenta);

}
