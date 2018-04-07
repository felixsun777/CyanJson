package com.cyan.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cyan.entity.Employee;
import com.cyan.service.EmployeeService;
import com.cyan.service.MenuService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/login/{username}")
	public Employee login(@PathVariable String username) {
		return employeeService.getEmployee(username);
	}
	
	@GetMapping("/menu")
	public HashMap<String, Integer> menu(){
		return menuService.getCount();
	}
}
