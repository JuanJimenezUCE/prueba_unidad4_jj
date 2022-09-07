package com.uce.edu.demo.supermercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermercado.repository.IProductoRepository;
import com.uce.edu.demo.supermercado.repository.modelo.Producto;
@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;
	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertar(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(producto);
	}

	@Override
	public Producto buscarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarPorCodigoBarras(codigoBarras);
	}

	@Override
	public Producto buscarPorCodigoBarrasCriteria(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarPorCodigoBarrasCriteria(codigoBarras);
	}

}
