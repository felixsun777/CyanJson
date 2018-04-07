package com.cyan.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyan.dao.OrdersDao;
import com.cyan.entity.Orderdetail;
import com.cyan.entity.Orders;

@Repository
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(Orders order) {
		sessionFactory.getCurrentSession().save(order);
	}

	@Override
	public void update(Orders order) {
		sessionFactory.getCurrentSession().update(order);
	}

	@Override
	public void delete(Integer orderId) {
		Orders order = (Orders) sessionFactory.getCurrentSession().load(Orders.class, orderId);
		sessionFactory.getCurrentSession().delete(order);
	}

	@Override
	public Orders getOrder(Integer orderId) {
		return (Orders) sessionFactory.getCurrentSession().get(Orders.class, orderId);
	}

	@Override
	public List<Orders> getAllOrders() {
		return sessionFactory.getCurrentSession().createQuery("from Orders").list();
	}


}
