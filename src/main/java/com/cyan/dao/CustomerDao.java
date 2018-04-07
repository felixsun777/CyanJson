package com.cyan.dao;

import java.util.List;

import com.cyan.entity.Customer;


public interface CustomerDao {

	public void insert(Customer customer);
	public void update(Customer customer);
	public void delete(Integer customerId);
	public Customer getCustomer(Integer customerId);
	public List<Customer> getAllCustomers();
	public List<Customer> getCustomerByUsername(String username);
	
}
