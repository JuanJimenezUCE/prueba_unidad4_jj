package com.uce.edu.demo.supermercado.repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;


import com.uce.edu.demo.supermercado.repository.modelo.Producto;
import com.uce.edu.demo.supermercado.repository.modelo.dto.ListaProductos;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED )
	public Producto buscarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery=this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :codigoBarras",Producto.class);
		myQuery.setParameter("codigoBarras", codigoBarras);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED )
	public Producto buscarPorCodigoBarrasCriteria(String codigoBarras) {
		// TODO Auto-generated method stub

		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();

	
		CriteriaQuery<Producto> myQuery = myCriteria.createQuery(Producto.class);

		Root<Producto> productoFrom = myQuery.from(Producto.class); 
	
		Predicate predicadoCodigo = myCriteria.equal(productoFrom.get("codigoBarras"), codigoBarras);

		myQuery.select(productoFrom).where(predicadoCodigo);

		TypedQuery<Producto> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public ListaProductos buscarProducto(String codigoBarras, Integer cantidad) {
		// TODO Auto-generated method stub
		
		TypedQuery<ListaProductos> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.supermercado.repository.modelo.dto.ListaProductos(p.codigoBarras,p.cantidad) FROM Persona p WHERE p.codigoBarras=:codigoBarras AND p.cantidad =:cantidad   ",
				ListaProductos.class);
		myQuery.setParameter("codigoBarras", codigoBarras);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getSingleResult();
	}

}
