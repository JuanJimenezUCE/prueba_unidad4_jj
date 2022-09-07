package com.uce.edu.demo.supermercado.repository;

import java.time.LocalDateTime;

import com.uce.edu.demo.supermercado.repository.modelo.Venta;
import com.uce.edu.demo.supermercado.repository.modelo.dto.ReporteVentas;

public interface IVentaRepository {

	public void insertar(Venta venta);
	
	public ReporteVentas reporteVentas(LocalDateTime fecha, String categoria, Integer Cantidad);
	
}
