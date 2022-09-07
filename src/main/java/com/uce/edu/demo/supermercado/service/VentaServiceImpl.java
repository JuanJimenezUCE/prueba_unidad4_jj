package com.uce.edu.demo.supermercado.service;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermercado.repository.IVentaRepository;
import com.uce.edu.demo.supermercado.repository.modelo.DetalleVenta;
import com.uce.edu.demo.supermercado.repository.modelo.Producto;
import com.uce.edu.demo.supermercado.repository.modelo.Venta;
import com.uce.edu.demo.supermercado.repository.modelo.dto.ListaProductos;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IProductoService iProductoService;
	@Autowired
	private IVentaRepository iVentaRepository;
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarVenta(List<ListaProductos> productos, String cedulaCliente, String nVenta) {
		// TODO Auto-generated method stub
		Venta v = new Venta();
		v.setNumero(nVenta);
		v.setCedulaCliente(cedulaCliente);
		v.setFecha(LocalDateTime.now());

		BigDecimal total = new BigDecimal(0);

		
	
		List<DetalleVenta> detalles = new ArrayList<>();
		
		
		
		for (ListaProductos p : productos) {
			
			Producto pro=this.iProductoService.buscarPorCodigoBarras(p.getCodigoBarras());
			pro.setStock(pro.getStock()-1);
			DetalleVenta detalle = new DetalleVenta();
			detalle.setPrecioUnitario(pro.getPrecio());
			detalle.setCantidad(p.getCantidad());
			
			if (pro.getStock() <= detalle.getCantidad()) {
				throw new RuntimeException();
			}
			
			detalle.setProducto(pro);
			detalle.setSubtotal(pro.getPrecio().multiply(new BigDecimal(detalle.getCantidad())));
			detalle.setVenta(v);
			detalles.add(detalle);
			total = total.add(detalle.getSubtotal());
		}

		v.setTotalVenta(total);
		v.setDetalles(detalles);
		
		this.iVentaRepository.insertar(v);
	}
}
