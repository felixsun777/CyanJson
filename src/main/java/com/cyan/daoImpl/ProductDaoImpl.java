package com.cyan.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyan.dao.ProductDao;
import com.cyan.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	@Override
	public void update(Product product) {
		sessionFactory.getCurrentSession().update(product);
	}

	@Override
	public void delete(Integer productId) {
		Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, productId);
		sessionFactory.getCurrentSession().delete(product);
	}

	@Override
	public Product getProduct(Integer productId) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

}
