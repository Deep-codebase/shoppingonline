package com.shop.ecomm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.ecomm.entity.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManager entityManager;
	
	/*
	 * SINGLE
	 * */
	
	@Override
	public Product get(int productId) {
		Session session = entityManager.unwrap(Session.class);
		try {			
			return session
						.get(Product.class,Integer.valueOf(productId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	/*
	 * LIST
	 * */
	
	@Override
	public List<Product> list() {
		Session session = entityManager.unwrap(Session.class);
		return session
					.createQuery("FROM Product" , Product.class)
						.getResultList();
	}

	/*
	 * INSERT
	 * */
	@Override
	public boolean add(Product product) {
		Session session = entityManager.unwrap(Session.class);
		try {			
			session.save(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	/*
	 * UPDATE
	 * */
	@Override
	public boolean update(Product product) {
		Session session = entityManager.unwrap(Session.class);
		try {			
			session.update(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		
	}

	
	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Product product) {
		try {
			Session session = entityManager.unwrap(Session.class);
			product.setActive(false);
			// call the update method
			return this.update(product);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;			
	}

	@Override
	public List<Product> listActiveProducts() {
		Session session = entityManager.unwrap(Session.class);
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return session
					.createQuery(selectActiveProducts, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		Session session = entityManager.unwrap(Session.class);
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return session
					.createQuery(selectActiveProductsByCategory, Product.class)
						.setParameter("active", true)
						.setParameter("categoryId",categoryId)
							.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		Session session = entityManager.unwrap(Session.class);
		return session
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();					
	}

	@Override
	public List<Product> getProductsByParam(String param, int count) {
		
		Session session = entityManager.unwrap(Session.class);
		String query = "FROM Product WHERE active = true ORDER BY " + param + " DESC";
		
		return session
					.createQuery(query,Product.class)
					.setFirstResult(0)
					.setMaxResults(count)
					.getResultList();
					
		
	}

}

