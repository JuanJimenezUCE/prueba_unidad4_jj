package com.uce.edu.demo.supermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.supermercado.repository.modelo.Producto;
import com.uce.edu.demo.supermercado.service.IGestorSupermercadoService;
import com.uce.edu.demo.supermercado.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private IGestorSupermercadoService gestorSupermercadoService;
	
	@Autowired
	private IProductoService productoService;
	
	@PostMapping("/insertar")
	public String insertarProducto(Producto producto) {
		this.gestorSupermercadoService.ingresarProducto(producto, producto.getStock());
		return "redirect:/productos/nuevoProducto";
	}
	
	
	@GetMapping("/nuevoProducto")
	public String paginaNuevaPersona(Producto producto) {
		return "vistaNuevoProducto";
	}
	
	@GetMapping("/buscarProducto/{codigoBarras}")
	public String bucarProducto(@PathVariable("codigoBarras") String codigoBarras, Model modelo) {
		System.out.println("El ID es: " + codigoBarras);
		Producto p= this.productoService.buscarPorCodigoBarrasCriteria(codigoBarras);
		modelo.addAttribute("producto", p);
		return "vistaProducto";
	}
}
