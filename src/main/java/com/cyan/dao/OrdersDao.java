package com.cyan.dao;

import java.util.List;

import com.cyan.entity.Orderdetail;
import com.cyan.entity.Orders;

public interface OrdersDao {

	public void insert(Orders order);
	public void update(Orders order);
	public void delete(Integer orderId);
	public Orders getOrder(Integer orderId);
	public List<Orders> getAllOrders();
}
