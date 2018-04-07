package com.cyan.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyan.dao.CustomerDao;
import com.cyan.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public void update(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
	}

	@Override
	public void delete(Integer userId) {
		Customer customer = (Customer) sessionFactory.getCurrentSession().load(Customer.class, userId);
		sessionFactory.getCurrentSession().delete(customer);
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}

	@Override
	public List<Customer> getCustomerByUsername(String username) {
		String hql = "from Customer where username=?";
		return sessionFactory.getCurrentSession().createQuery(hql).setString(0, username).list();
	}

}
