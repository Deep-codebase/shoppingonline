package com.shop.ecomm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.ecomm.entity.Cart;
import com.shop.ecomm.entity.CartLine;

@Repository
@Transactional
public class CartLineDAOImpl implements CartLineDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		Session session = entityManager.unwrap(Session.class);
		String query = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
		try {
			
			CartLine cartline = session.
					createQuery(query,CartLine.class)
										.setParameter("cartId", cartId)
										.setParameter("productId", productId)
											.getResultList().get(0);
			return cartline;
			
		}catch(Exception ex) {
			return null;	
		}
		
	}

	@Override
	public boolean add(CartLine cartLine) {
		Session session = entityManager.unwrap(Session.class);
		try {
			session.persist(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		Session session = entityManager.unwrap(Session.class);
		try {
			session.update(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(CartLine cartLine) {	
		Session session = entityManager.unwrap(Session.class);
		try {			
			session.delete(cartLine);
			return true;
		}catch(Exception ex) {
			return false;
		}		
	}


	@Override
	public List<CartLine> list(int cartId) {
		Session session = entityManager.unwrap(Session.class);
		String query = "FROM CartLine WHERE cartId = :cartId";
		return session
					.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
										.getResultList();		
	}

	@Override
	public CartLine get(int id) {		
		Session session = entityManager.unwrap(Session.class);
		return session.get(CartLine.class, Integer.valueOf(id));
	}

	@Override
	public boolean updateCart(Cart cart) {
		Session session = entityManager.unwrap(Session.class);
		try {			
			session.update(cart);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		Session session = entityManager.unwrap(Session.class);
		String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";
		return session
					  .createQuery(query, CartLine.class)
				    	.setParameter("cartId", cartId)
							.setParameter("available", true)
								.getResultList();
	}

//	@Override
//	public boolean addOrderDetail(OrderDetail orderDetail) {
//		try {			
//			sessionFactory.getCurrentSession().persist(orderDetail);			
//			return true;
//		}
//		catch(Exception ex) {
//			return false;
//		}
//	}
		
}

