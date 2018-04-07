package com.cyan.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyan.dao.ProductDao;
import com.cyan.entity.Department;
import com.cyan.entity.Product;
import com.cyan.entity.Review;
import com.cyan.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{


	@Autowired
	private ProductDao productDao;
	
	@Override
	@Transactional
	public List<Product> retrieveAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	@Transactional
	public boolean insertProduct(Product product) {
		productDao.insert(product);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteProduct(Integer productId) {
		productDao.delete(productId);
		return true;
	}

	@Override
	@Transactional
	public boolean updateProduct(Product product) {
		productDao.update(product);
		return true;
	}

	@Override
	@Transactional
	public List<Review> retrieveProductReviews(Integer productId) {
		return new ArrayList<Review>(productDao.getProduct(productId).getReviews());
	}

}
