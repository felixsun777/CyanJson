package com.cyan.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyan.dao.OrdersDao;
import com.cyan.entity.Orderdetail;
import com.cyan.entity.Orders;
import com.cyan.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Override
	@Transactional
	public List<Orders> retrieveAllOrders() {
		return ordersDao.getAllOrders();
	}

	@Override
	@Transactional
	public boolean deleteOrder(Integer orderId) {
		ordersDao.delete(orderId);
		return true;
	}

	@Override
	@Transactional
	public boolean updateOrder(Orders order) {
		ordersDao.update(order);
		return true;
	}

	@Override
	@Transactional
	public List<Orderdetail> retrieveOrderDetails(Integer orderId) {	
		Orders order = ordersDao.getOrder(orderId);
		return new ArrayList<Orderdetail>(order.getDetails());
	}

	
}
