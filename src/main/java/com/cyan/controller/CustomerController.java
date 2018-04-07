package com.cyan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cyan.entity.Category;
import com.cyan.entity.Customer;
import com.cyan.entity.Department;
import com.cyan.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> customer() {
		return customerService.retrieveAllCustomers();
	}
	
	@PostMapping("/insert")
	public void insertCustomer(@RequestBody Customer customer) {
		customerService.insertCustomer(customer);
	}
	
	
	@DeleteMapping("/delete/{userId}")
	public void deleteCustomer(@PathVariable Integer userId){
		customerService.deleteCustomer(userId);
	}
	

	
	@PutMapping("/update")
	public void updateCustomer(@RequestBody Customer customer){
		customerService.updateCustomer(customer);
	}
	
}
