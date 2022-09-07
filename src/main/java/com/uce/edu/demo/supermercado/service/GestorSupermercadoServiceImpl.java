package com.uce.edu.demo.supermercado.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermercado.repository.modelo.Producto;
import com.uce.edu.demo.supermercado.repository.modelo.dto.ListaProductos;

@Service
public class GestorSupermercadoServiceImpl implements IGestorSupermercadoService {

	@Autowired
	private IProductoService iProductoService;
	@Override
	@Transactional(value =TxType.REQUIRED)
	public void ingresarProducto(Producto producto, Integer stock) {
		// TODO Auto-generated method stub
	
		
	//	if(producto.getCodigoBarras()==null) {
			
			//producto.setStock(stock);
			this.iProductoService.insertar(producto);
		
			
		//} else {
			
			//Producto producto1 = this.iProductoService.buscarPorCodigoBarras(producto.getCodigoBarras());
			//producto1.setStock(producto1.getStock() + stock);
			//this.iProductoService.actualizar(producto1);
			
	//	}
		
		
		
		
	
	}

	
}

