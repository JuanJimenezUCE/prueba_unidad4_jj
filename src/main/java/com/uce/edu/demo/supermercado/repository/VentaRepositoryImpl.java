package com.uce.edu.demo.supermercado.repository;


import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;


import com.uce.edu.demo.supermercado.repository.modelo.Venta;
import com.uce.edu.demo.supermercado.repository.modelo.dto.ReporteVentas;
@Repository
@Transactional
public class VentaRepositoryImpl implements IVentaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(venta);
	}
	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public ReporteVentas reporteVentas(LocalDateTime fecha, String categoria, Integer Cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<ReporteVentas> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.supermercado.repository.modelo.dto.ReporteVentas(p.codigoBarras, p.nombre, d.cantidad, d.precioUnitario,d.subtotal) FROM Venta v WHERE v.fecha = :fecha AND p.categoria = :categoria",
				ReporteVentas.class);
		myQuery.setParameter("fecha", fecha);
		myQuery.setParameter("categoria", categoria);
		
		return myQuery.getSingleResult();
	}

}
