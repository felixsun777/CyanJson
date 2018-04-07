package com.cyan.dao;

import java.util.List;

import com.cyan.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployeeByUsername(String username);
}
