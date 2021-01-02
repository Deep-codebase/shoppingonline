package com.shop.ecomm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.ecomm.entity.Category;
import com.shop.ecomm.entity.Product;



@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Category> list() {

		Session session = entityManager.unwrap(Session.class);
		String selectActiveCategory = "from Category WHERE active = :active";
		Query query = session.createQuery(selectActiveCategory);
	
		query.setParameter("active", true);

		return query.getResultList();

	}

	@Override
	@Transactional
	public Category get(int id) {

		Session session = entityManager.unwrap(Session.class);
		return session.get(Category.class, Integer.valueOf(id));

	}

	@Override
	@Transactional
	public boolean add(Category category) {
		Session session = entityManager.unwrap(Session.class);
		try {
			// add the category to the database table
			session.save(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category category) {
		Session session = entityManager.unwrap(Session.class);
		try {
			// add the category to the database table
			session.update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		Session session = entityManager.unwrap(Session.class);
		category.setActive(false);

		try {
			// add the category to the database table
			session.update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public void backendmessage() {
		System.out.println("From backend");
	}

	@Override
	public List<Product> mostviewedProducts() {
		Session session = entityManager.unwrap(Session.class);
		String selectMostViewed = "from Product product order by product.views desc";
		Query query = session.createQuery(selectMostViewed);
	
		return query.getResultList();
	}

}
