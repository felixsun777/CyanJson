package com.cyan.dao;

import java.util.List;

import com.cyan.entity.Product;;

public interface ProductDao {

	public void insert(Product product);
	public void update(Product product);
	public void delete(Integer productId);
	public Product getProduct(Integer productId);
	public List<Product> getAllProducts();
	
}
