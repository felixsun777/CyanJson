package com.cyan.serviceimpl;

import java.util.List;

import javax.persistence.Temporal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyan.dao.CustomerDao;
import com.cyan.entity.Customer;
import com.cyan.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> retrieveAllCustomers() {	
		List<Customer> customers = customerDao.getAllCustomers();		
		return customers;
	}

	@Override
	@Transactional
	public boolean insertCustomer(Customer customer) {
		customerDao.insert(customer);
		return true;
	}
	
	@Override
	@Transactional
	public boolean deleteCustomer(Integer userId) {
		customerDao.delete(userId);
		return true;
	}

	@Override
	@Transactional
	public boolean updateCustomer(Customer customer) {
		customerDao.update(customer);
		return true;
	}

	@Override
	@Transactional
	public boolean verify(Customer customer) {
		List<Customer> list = customerDao.getCustomerByUsername(customer.getUsername());
		if(list.size()==0 || !list.get(0).getPassword().equals(customer.getPassword())) {
			return false;
		}
		return true;
	}
	
	@Override
	@Transactional
	public Customer getCustomerByUserName(String username) {
		List<Customer> list = customerDao.getCustomerByUsername(username);
		if (!list.isEmpty()) {
			return list.get(0);
		}else {
			return null;
		}
		
	}

}
