package com.cyan.serviceimpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyan.dao.CategoryDao;
import com.cyan.dao.CustomerDao;
import com.cyan.dao.OrdersDao;
import com.cyan.dao.ProductDao;
import com.cyan.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrdersDao ordersDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	@Transactional
	public HashMap<String, Integer> getCount() {
		HashMap<String, Integer> count = new HashMap<>();
		count.put("product", (int) productDao.getAllProducts().parallelStream().count());
		count.put("order", (int) ordersDao.getAllOrders().parallelStream().count());
		count.put("customer", (int)customerDao.getAllCustomers().parallelStream().count());
		count.put("category", (int)categoryDao.getAllCategories().parallelStream().count());
		return count;
	}

}
