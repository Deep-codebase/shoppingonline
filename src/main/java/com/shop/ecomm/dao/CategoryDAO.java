package com.shop.ecomm.dao;

import java.util.List;

import com.shop.ecomm.entity.Category;
import com.shop.ecomm.entity.Product;


public interface CategoryDAO {

	public Category get(int id);

	List<Category> list();
	
	public List<Product> mostviewedProducts();

	boolean add(Category category);

	boolean update(Category category);

	boolean delete(Category category);
	
	public void backendmessage();

}
