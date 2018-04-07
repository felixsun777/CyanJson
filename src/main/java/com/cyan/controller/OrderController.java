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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cyan.entity.Orderdetail;
import com.cyan.entity.Orders;
import com.cyan.service.OrderService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

	@Autowired 
	private OrderService orderService;
	
	@GetMapping("/orders")
	public List<Orders> orders(HttpServletRequest request) {
		return orderService.retrieveAllOrders();
	}
	
	@DeleteMapping("/delete/{orderId}")
	public void deleteOrder(@PathVariable Integer orderId){
		orderService.deleteOrder(orderId);
	}
	
	
	@PutMapping("/update")
	public void updateOrder(@RequestBody Orders order) {
		orderService.updateOrder(order);
	}
	
	@GetMapping("/detail/{orderId}")
	public List<Orderdetail> OrderDetailPage(@PathVariable Integer orderId) {
		return orderService.retrieveOrderDetails(orderId);
	}
	
	
	
}
