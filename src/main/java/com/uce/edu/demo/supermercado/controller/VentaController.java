package com.uce.edu.demo.supermercado.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.supermercado.repository.IProductoRepository;
import com.uce.edu.demo.supermercado.repository.modelo.Producto;
import com.uce.edu.demo.supermercado.repository.modelo.Venta;
import com.uce.edu.demo.supermercado.repository.modelo.dto.ListaProductos;
import com.uce.edu.demo.supermercado.service.IVentaService;

@Controller
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	private IVentaService ventaService;
	
	@Autowired
	private IProductoRepository productoRepository;
	

	
	@PostMapping("/insertar")
	public String insertarVenta(Venta venta,ListaProductos producto) {
		
		ListaProductos pro = this.productoRepository.buscarProducto(producto.getCodigoBarras(), producto.getCantidad());
		List<ListaProductos> lista = new ArrayList<>();
		lista.add(pro);		
		
		this.ventaService.realizarVenta(lista, venta.getCedulaCliente(), venta.getNumero());
		return "redirect:/productos/nuevoProducto";
	}
	

	@GetMapping("/nuevaVenta")
	public String paginaNuevaPersona(Venta venta) {
		return "vistaNuevaVenta";
	}
	
}
